package com.baidu.tieba.frs.frsfeedforums;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private LikeModel cdr;
    private boolean fBP;
    private View fBU;
    private View fED;
    private LinearLayout fEF;
    private TextView fEG;
    private ImageView fEH;
    private TextView fEI;
    private View fEJ;
    private List<FeedForumData> fEL;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> fEK = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean fEM = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bd.cF(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.cdr.el(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).bT("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").bT("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.fEI.getId() && v.Z(a.this.fEL) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.fEL)));
                    TiebaStatic.log(new an("c10046").bT("fid", a.this.mForumId));
                }
            } else {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str3 = "";
                    if (a.this.mType == 1) {
                        str3 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    a.this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str3)));
                    if (a.this.mType == 2) {
                        str = "c10042";
                    } else {
                        str = "c10030";
                    }
                    TiebaStatic.log(new an(str).bT("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d eXt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cdr.getErrorCode(), a.this.cdr.getErrorString())) {
                AntiHelper.aJ(a.this.mTbPageContext.getPageActivity(), a.this.cdr.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.cdr.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.cdr.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.Z(a.this.fEL) > 0 && rVar != null) {
                    Iterator it = a.this.fEK.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.fET.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(rVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.fEL.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.fEL.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.fEL.size() > 0) {
                                    a.this.refreshUI();
                                } else {
                                    a.this.hide();
                                }
                            }
                        }, 1000L);
                    }
                }
            }
        }
    };

    public a() {
    }

    public a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        a(tbPageContext, view, i, z, bdUniqueId);
    }

    public void a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.fEF = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.fED = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.fEJ = view.findViewById(R.id.layout_like_feed_forum_header);
        this.fEG = (TextView) this.fEF.findViewById(R.id.like_feed_forums_label);
        this.fEH = (ImageView) this.fEF.findViewById(R.id.like_feed_forums_arrow);
        this.fEH.setOnClickListener(this.mOnClickListener);
        this.fEI = (TextView) this.fEF.findViewById(R.id.feed_forums_more);
        this.fBU = view.findViewById(R.id.feed_forum_bottom_line);
        this.fEI.setOnClickListener(this.mOnClickListener);
        this.cdr = new LikeModel(tbPageContext);
        this.cdr.setUniqueId(bdUniqueId);
        this.cdr.setLoadDataCallBack(this.eXt);
        this.mType = i;
        this.fBP = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.fEL = list;
        refreshUI();
        if (this.mType == 2 && !this.fEM) {
            TiebaStatic.log(new an("c10035").bT("fid", this.mForumId));
            this.fEM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.Z(this.fEL) == 0) {
            hide();
            return;
        }
        show();
        int size = this.fEL.size() > 2 ? 2 : this.fEL.size();
        int size2 = size - this.fEK.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.fEF.addView(inflate);
                this.fEK.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.fEK.size() - 1;
                this.fEF.removeView(this.fEK.get(size3).cYf);
                this.fEK.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.fEL.get(i4);
            b bVar = this.fEK.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.cYf.setTag(feedForumData);
                bVar.cYf.setOnClickListener(this.mOnClickListener);
                bVar.fEQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.fEQ.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.fER.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), sa(feedForumData.getMemberCount()), sa(feedForumData.getPostNum())));
                bVar.fES.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.fET.setClickable(true);
                    bVar.fET.setOnClickListener(this.mOnClickListener);
                    bVar.fET.setTag(feedForumData);
                    bVar.fET.ev(false);
                    bVar.fET.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.fBP) {
            this.fBU.setVisibility(0);
        } else {
            this.fBU.setVisibility(8);
        }
        bpu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.fET != null) {
            bVar.fET.ev(true);
            bVar.fET.setEnabled(false);
        }
    }

    private String sa(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.mO(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.fEL != null) {
                    a.this.fEL.clear();
                }
                a.this.hide();
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mTbPageContext).agI();
    }

    private void bpu() {
        am.l(this.fEF, R.color.cp_bg_line_d);
        am.l(this.fED, R.color.cp_bg_line_b);
        am.l(this.fEJ, R.color.cp_bg_line_d);
        am.f(this.fEG, R.color.cp_cont_c, 1);
        am.c(this.fEH, (int) R.drawable.icon_frs_recommend_arrow_down);
        am.f(this.fEI, R.color.cp_cont_e, 1);
        for (b bVar : this.fEK) {
            am.k(bVar.cYf, R.drawable.frs_like_feed_forum_item_bg);
            am.f(bVar.mTitle, R.color.cp_cont_b, 1);
            am.f(bVar.fER, R.color.cp_cont_c, 1);
            am.f(bVar.fES, R.color.cp_link_tip_d, 1);
            bVar.fET.ev(!bVar.fET.isEnabled());
        }
    }

    public void hide() {
        this.fEF.setVisibility(8);
    }

    public void show() {
        this.fEF.setVisibility(0);
    }
}
