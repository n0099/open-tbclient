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
import com.baidu.live.data.w;
import com.baidu.live.r.a;
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
    private static final int fpL = "   ".length();
    private w fbN;
    private PersonCardActivity fpM;
    private TextView fpN;
    private TextView fpO;
    private TextView fpP;
    private View fpQ;
    private List<AlaLiveMarkData> fpR;
    private List<AlaLiveMarkData> fpS;
    private List<AlaLiveMarkData> fpT;
    private int fpU = 0;
    private View mContentView;
    private View mRootView;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.fpM = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.fpN = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.fpO = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.fpP = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.fpO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bqw();
                }
            });
            this.fpQ = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bqw() {
        if (this.fbN != null && com.baidu.live.s.a.wR().atk.abe != null) {
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.fbN.user_id)) {
                String str = com.baidu.live.s.a.wR().atk.abe.aaP;
                if (!TextUtils.isEmpty(str)) {
                    UrlManager.getInstance().dealOneLink(this.fpM.getPageContext(), new String[]{str});
                }
            } else {
                String str2 = com.baidu.live.s.a.wR().atk.abe.aaQ;
                if (str2 != null && this.fbN != null) {
                    if (str2.endsWith("/")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    String str3 = this.fbN.user_id;
                    String str4 = this.fbN.portrait;
                    String str5 = this.fbN.user_nickname;
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
                    this.fpM.finish();
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

    public void setData(w wVar) {
        if (wVar != null) {
            this.fbN = wVar;
            if (this.fpR == null) {
                this.fpR = new ArrayList();
            }
            this.fpR.clear();
            if (this.fpS == null) {
                this.fpS = new ArrayList();
            }
            this.fpS.clear();
            if (this.fpT == null) {
                this.fpT = new ArrayList();
            }
            this.fpT.clear();
            bG(wVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.fpR)) {
                a("", "", this.fpN, this.fpR);
            }
            if (!ListUtils.isEmpty(this.fpS)) {
                int i = wVar.Zs;
                if (i <= 0) {
                    i = this.fpU;
                }
                a("  ", i + this.fpM.getResources().getString(a.i.ala_count_mei), this.fpO, this.fpS);
                this.fpO.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.fpQ.setVisibility(0);
            } else {
                this.fpO.setText("");
                this.fpO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.fpQ.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.fpT)) {
                a(this.fbN.getNameShow() + HanziToPinyin.Token.SEPARATOR, "", this.fpP, this.fpT);
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
                    final int i4 = length + (fpL * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.fpM, alaLiveMarkData, this.fbN.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
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
                        new com.baidu.live.view.c(this.fpM, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.fpM.bqg())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
                    if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                        this.fpS.add(alaLiveMarkData2);
                    } else if (alaLiveMarkData2.type == 2) {
                        this.fpT.add(alaLiveMarkData2);
                    } else {
                        this.fpR.add(alaLiveMarkData2);
                    }
                }
                this.fpU = this.fpS.size();
                if (this.fpU > 2) {
                    this.fpS = this.fpS.subList(0, 2);
                }
                if (this.fpR.size() > 3) {
                    this.fpR = this.fpR.subList(0, 3);
                }
            }
        }
    }
}
