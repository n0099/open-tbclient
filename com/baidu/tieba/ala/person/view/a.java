package com.baidu.tieba.ala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.u;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.view.c;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final int fmB = "   ".length();
    private u eZi;
    private PersonCardActivity fmC;
    private TextView fmD;
    private TextView fmE;
    private TextView fmF;
    private View fmG;
    private List<AlaLiveMarkData> fmH;
    private List<AlaLiveMarkData> fmI;
    private List<AlaLiveMarkData> fmJ;
    private int fmK = 0;
    private View mContentView;
    private View mRootView;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.fmC = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.fmD = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.fmE = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.fmF = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.fmE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bpv();
                }
            });
            this.fmG = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bpv() {
        if (this.eZi != null && com.baidu.live.r.a.wA().asy.aaQ != null) {
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.eZi.user_id)) {
                String str = com.baidu.live.r.a.wA().asy.aaQ.aaC;
                if (!TextUtils.isEmpty(str)) {
                    UrlManager.getInstance().dealOneLink(this.fmC.getPageContext(), new String[]{str});
                }
            } else {
                String str2 = com.baidu.live.r.a.wA().asy.aaQ.aaD;
                if (str2 != null && this.eZi != null) {
                    if (str2.endsWith("/")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    String str3 = this.eZi.user_id;
                    String str4 = this.eZi.portrait;
                    String str5 = this.eZi.user_nickname;
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
                    this.fmC.finish();
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

    public void setData(u uVar) {
        if (uVar != null) {
            this.eZi = uVar;
            if (this.fmH == null) {
                this.fmH = new ArrayList();
            }
            this.fmH.clear();
            if (this.fmI == null) {
                this.fmI = new ArrayList();
            }
            this.fmI.clear();
            if (this.fmJ == null) {
                this.fmJ = new ArrayList();
            }
            this.fmJ.clear();
            bG(uVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.fmH)) {
                a("", "", this.fmD, this.fmH);
            }
            if (!ListUtils.isEmpty(this.fmI)) {
                int i = uVar.Ze;
                if (i <= 0) {
                    i = this.fmK;
                }
                a("  ", i + this.fmC.getResources().getString(a.i.ala_count_mei), this.fmE, this.fmI);
                this.fmE.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.fmG.setVisibility(0);
            } else {
                this.fmE.setText("");
                this.fmE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.fmG.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.fmJ)) {
                a(this.eZi.getNameShow() + HanziToPinyin.Token.SEPARATOR, "", this.fmF, this.fmJ);
            }
        }
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        for (int i = 0; i < list.size(); i++) {
            str = str + "   ";
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (alaLiveMarkData != null) {
                    final int i4 = length + (fmB * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.fmC, alaLiveMarkData, this.eZi.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    } else {
                        new com.baidu.live.view.c(this.fmC, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
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

    private void bG(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.fmC.bpf())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
                    if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                        this.fmI.add(alaLiveMarkData2);
                    } else if (alaLiveMarkData2.type == 2) {
                        this.fmJ.add(alaLiveMarkData2);
                    } else {
                        this.fmH.add(alaLiveMarkData2);
                    }
                }
                this.fmK = this.fmI.size();
                if (this.fmK > 2) {
                    this.fmI = this.fmI.subList(0, 2);
                }
                if (this.fmH.size() > 3) {
                    this.fmH = this.fmH.subList(0, 3);
                }
            }
        }
    }
}
