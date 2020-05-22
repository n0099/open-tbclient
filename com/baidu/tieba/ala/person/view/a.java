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
import com.baidu.live.data.ad;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.c;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final int gmv = "   ".length();
    private ad fXT;
    private View gmA;
    private List<AlaLiveMarkData> gmB;
    private List<AlaLiveMarkData> gmC;
    private List<AlaLiveMarkData> gmD;
    private PersonCardActivity gmw;
    private TextView gmx;
    private TextView gmy;
    private TextView gmz;
    private View mContentView;
    private View mRootView;
    private int gmE = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.gmw = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.gmx = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.gmy = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.gmz = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.gmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bIe();
                }
            });
            this.gmA = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bIe() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.fXT != null && com.baidu.live.v.a.Ge().aYP.aAR != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.fXT.user_id)) {
                    String str = com.baidu.live.v.a.Ge().aYP.aAR.aAD;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.gmw.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.v.a.Ge().aYP.aAR.aAE;
                    if (str2 != null && this.fXT != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.fXT.user_id;
                        String str4 = this.fXT.portrait;
                        String str5 = this.fXT.user_nickname;
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
                        this.gmw.finish();
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

    public void setData(ad adVar) {
        if (adVar != null) {
            this.fXT = adVar;
            if (this.gmB == null) {
                this.gmB = new ArrayList();
            }
            this.gmB.clear();
            if (this.gmC == null) {
                this.gmC = new ArrayList();
            }
            this.gmC.clear();
            if (this.gmD == null) {
                this.gmD = new ArrayList();
            }
            this.gmD.clear();
            boolean bM = bM(adVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.gmB)) {
                a("", "", this.gmx, this.gmB);
            }
            if (!ListUtils.isEmpty(this.gmC) || bM) {
                int i = adVar.aza;
                if (i <= 0) {
                    i = this.gmE;
                }
                a("  ", i + this.gmw.getResources().getString(a.i.ala_count_mei), this.gmy, this.gmC);
                this.gmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.gmA.setVisibility(0);
            } else {
                this.gmy.setText("");
                this.gmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.gmA.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.gmD)) {
                a(bIf() + " ", "", this.gmz, this.gmD);
            }
        }
    }

    private String bIf() {
        String nameShow = this.fXT.getNameShow();
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
                    final int i4 = length + (gmv * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.gmw, alaLiveMarkData, this.fXT.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
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
                        new com.baidu.live.view.c(this.gmw, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
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

    private boolean bM(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.gmw.bHL())) {
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
                this.gmC.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.gmD.add(alaLiveMarkData2);
            } else {
                this.gmB.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.gmE = this.gmC.size();
        if (this.gmE > 2) {
            this.gmC = this.gmC.subList(0, 2);
        }
        if (this.gmB.size() > 3) {
            this.gmB = this.gmB.subList(0, 3);
        }
        return z;
    }
}
