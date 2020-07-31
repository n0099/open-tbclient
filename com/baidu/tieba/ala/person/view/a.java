package com.baidu.tieba.ala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.af;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.c;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final int gES = "   ".length();
    private PersonCardActivity gET;
    private TextView gEU;
    private TextView gEV;
    private TextView gEW;
    private View gEX;
    private List<AlaLiveMarkData> gEY;
    private List<AlaLiveMarkData> gEZ;
    private List<AlaLiveMarkData> gFa;
    private af gqd;
    private View mContentView;
    private View mRootView;
    private int gFb = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.gET = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.gEU = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.gEV = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.gEW = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.gEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOt();
                }
            });
            this.gEX = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bOt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.gqd != null && com.baidu.live.v.a.Hs().beo.aEx != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.gqd.user_id)) {
                    String str = com.baidu.live.v.a.Hs().beo.aEx.aEj;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.gET.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.v.a.Hs().beo.aEx.aEk;
                    if (str2 != null && this.gqd != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.gqd.user_id;
                        String str4 = this.gqd.portrait;
                        String str5 = this.gqd.user_nickname;
                        StringBuilder sb = new StringBuilder();
                        sb.append("id=");
                        sb.append(ExtraParamsManager.getEncryptionUserId(str3));
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("portrait=");
                        try {
                            sb.append(URLEncoder.encode(str4, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("nickname=");
                        try {
                            sb.append(URLEncoder.encode(str5, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!str2.contains("?")) {
                            sb.insert(0, "?");
                        } else {
                            sb.insert(0, ETAG.ITEM_SEPARATOR);
                        }
                        sb.insert(0, str2);
                        String sb2 = sb.toString();
                        this.gET.finish();
                        if (!TextUtils.isEmpty(sb2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, sb2));
                        }
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
            }
        }
    }

    public void setData(af afVar) {
        if (afVar != null) {
            this.gqd = afVar;
            if (this.gEY == null) {
                this.gEY = new ArrayList();
            }
            this.gEY.clear();
            if (this.gEZ == null) {
                this.gEZ = new ArrayList();
            }
            this.gEZ.clear();
            if (this.gFa == null) {
                this.gFa = new ArrayList();
            }
            this.gFa.clear();
            boolean cc = cc(afVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.gEY)) {
                a("", "", this.gEU, this.gEY);
            }
            if (!ListUtils.isEmpty(this.gEZ) || cc) {
                int i = afVar.aCM;
                if (i <= 0) {
                    i = this.gFb;
                }
                a("  ", i + this.gET.getResources().getString(a.i.ala_count_mei), this.gEV, this.gEZ);
                this.gEV.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.gEX.setVisibility(0);
            } else {
                this.gEV.setText("");
                this.gEV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.gEX.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.gFa)) {
                a(bOu() + " ", "", this.gEW, this.gFa);
            }
        }
    }

    private String bOu() {
        String nameShow = this.gqd.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                return TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            return nameShow;
        }
        return "";
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = str + "   ";
            }
        }
        String str3 = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(str3);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (alaLiveMarkData != null) {
                    final int i4 = length + (gES * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.gET, alaLiveMarkData, this.gqd.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    } else {
                        new com.baidu.live.view.c(this.gET, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private boolean cc(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.gET.bOb())) {
                    linkedList.add(alaLiveMarkData);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return false;
        }
        boolean z = false;
        for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
            if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                this.gEZ.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.gFa.add(alaLiveMarkData2);
            } else {
                this.gEY.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.gFb = this.gEZ.size();
        if (this.gFb > 2) {
            this.gEZ = this.gEZ.subList(0, 2);
        }
        if (this.gEY.size() > 3) {
            this.gEY = this.gEY.subList(0, 3);
        }
        return z;
    }
}
