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
import com.baidu.live.data.ah;
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
/* loaded from: classes7.dex */
public class a {
    private static final int gRs = "   ".length();
    private ah gCV;
    private List<AlaLiveMarkData> gRA;
    private PersonCardActivity gRt;
    private TextView gRu;
    private TextView gRv;
    private TextView gRw;
    private View gRx;
    private List<AlaLiveMarkData> gRy;
    private List<AlaLiveMarkData> gRz;
    private View mContentView;
    private View mRootView;
    private int gRB = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.gRt = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.gRu = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.gRv = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.gRw = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.gRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bYt();
                }
            });
            this.gRx = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bYt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.gCV != null && com.baidu.live.w.a.Nk().bka.aJH != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.gCV.user_id)) {
                    String str = com.baidu.live.w.a.Nk().bka.aJH.aJt;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.gRt.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.w.a.Nk().bka.aJH.aJu;
                    if (str2 != null && this.gCV != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.gCV.user_id;
                        String str4 = this.gCV.portrait;
                        String str5 = this.gCV.user_nickname;
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
                        this.gRt.finish();
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

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.gCV = ahVar;
            if (this.gRy == null) {
                this.gRy = new ArrayList();
            }
            this.gRy.clear();
            if (this.gRz == null) {
                this.gRz = new ArrayList();
            }
            this.gRz.clear();
            if (this.gRA == null) {
                this.gRA = new ArrayList();
            }
            this.gRA.clear();
            boolean ce = ce(ahVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.gRy)) {
                a("", "", this.gRu, this.gRy);
            }
            if (!ListUtils.isEmpty(this.gRz) || ce) {
                int i = ahVar.aHW;
                if (i <= 0) {
                    i = this.gRB;
                }
                a("  ", i + this.gRt.getResources().getString(a.i.ala_count_mei), this.gRv, this.gRz);
                this.gRv.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.gRx.setVisibility(0);
            } else {
                this.gRv.setText("");
                this.gRv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.gRx.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.gRA)) {
                a(bYu() + " ", "", this.gRw, this.gRA);
            }
        }
    }

    private String bYu() {
        String nameShow = this.gCV.getNameShow();
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
                    final int i4 = length + (gRs * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.gRt, alaLiveMarkData, this.gCV.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
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
                        new com.baidu.live.view.c(this.gRt, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
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

    private boolean ce(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.gRt.bYb())) {
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
                this.gRz.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.gRA.add(alaLiveMarkData2);
            } else {
                this.gRy.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.gRB = this.gRz.size();
        if (this.gRB > 2) {
            this.gRz = this.gRz.subList(0, 2);
        }
        if (this.gRy.size() > 3) {
            this.gRy = this.gRy.subList(0, 3);
        }
        return z;
    }
}
