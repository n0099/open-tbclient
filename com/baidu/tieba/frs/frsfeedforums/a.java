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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
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
    private LikeModel bUq;
    private boolean fgN;
    private View fgS;
    private TextView fjA;
    private ImageView fjB;
    private TextView fjC;
    private View fjD;
    private List<FeedForumData> fjF;
    private View fjx;
    private LinearLayout fjz;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> fjE = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean fjG = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (bc.cZ(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.bUq.dV(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new am(str2).bJ(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new am("c10029").bJ(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != d.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.fjC.getId() && v.S(a.this.fjF) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.fjF)));
                    TiebaStatic.log(new am("c10046").bJ(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new am(str).bJ(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d eCS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aB(a.this.bUq.getErrorCode(), a.this.bUq.getErrorString())) {
                AntiHelper.aU(a.this.mTbPageContext.getPageActivity(), a.this.bUq.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.bUq.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.bUq.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.S(a.this.fjF) > 0 && rVar != null) {
                    Iterator it = a.this.fjE.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.fjN.getTag();
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
                                Iterator it2 = a.this.fjF.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.fjF.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.fjF.size() > 0) {
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
        this.fjz = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.fjx = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.fjD = view.findViewById(d.g.layout_like_feed_forum_header);
        this.fjA = (TextView) this.fjz.findViewById(d.g.like_feed_forums_label);
        this.fjB = (ImageView) this.fjz.findViewById(d.g.like_feed_forums_arrow);
        this.fjB.setOnClickListener(this.mOnClickListener);
        this.fjC = (TextView) this.fjz.findViewById(d.g.feed_forums_more);
        this.fgS = view.findViewById(d.g.feed_forum_bottom_line);
        this.fjC.setOnClickListener(this.mOnClickListener);
        this.bUq = new LikeModel(tbPageContext);
        this.bUq.setUniqueId(bdUniqueId);
        this.bUq.setLoadDataCallBack(this.eCS);
        this.mType = i;
        this.fgN = z;
    }

    public void g(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.fjF = list;
        refreshUI();
        if (this.mType == 2 && !this.fjG) {
            TiebaStatic.log(new am("c10035").bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.fjG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.S(this.fjF) == 0) {
            hide();
            return;
        }
        show();
        int size = this.fjF.size() > 2 ? 2 : this.fjF.size();
        int size2 = size - this.fjE.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.h.frs_header_feed_forum_item;
                } else {
                    i = d.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.fjz.addView(inflate);
                this.fjE.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.fjE.size() - 1;
                this.fjz.removeView(this.fjE.get(size3).cOt);
                this.fjE.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.fjF.get(i4);
            b bVar = this.fjE.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.cOt.setTag(feedForumData);
                bVar.cOt.setOnClickListener(this.mOnClickListener);
                bVar.fjK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.fjK.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.fjL.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.j.attention_post_count), qE(feedForumData.getMemberCount()), qE(feedForumData.getPostNum())));
                bVar.fjM.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.fjN.setClickable(true);
                    bVar.fjN.setOnClickListener(this.mOnClickListener);
                    bVar.fjN.setTag(feedForumData);
                    bVar.fjN.dU(false);
                    bVar.fjN.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.fgN) {
            this.fgS.setVisibility(0);
        } else {
            this.fgS.setVisibility(8);
        }
        bfZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.fjN != null) {
            bVar.fjN.dU(true);
            bVar.fjN.setEnabled(false);
        }
    }

    private String qE(int i) {
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
        aVar.ly(this.mTbPageContext.getPageActivity().getString(d.j.not_intrested));
        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.fjF != null) {
                    a.this.fjF.clear();
                }
                a.this.hide();
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mTbPageContext).aaZ();
    }

    private void bfZ() {
        al.l(this.fjz, d.C0277d.cp_bg_line_d);
        al.l(this.fjx, d.C0277d.cp_bg_line_b);
        al.l(this.fjD, d.C0277d.cp_bg_line_d);
        al.d(this.fjA, d.C0277d.cp_cont_c, 1);
        al.c(this.fjB, d.f.icon_frs_recommend_arrow_down);
        al.d(this.fjC, d.C0277d.cp_cont_e, 1);
        for (b bVar : this.fjE) {
            al.k(bVar.cOt, d.f.frs_like_feed_forum_item_bg);
            al.d(bVar.mTitle, d.C0277d.cp_cont_b, 1);
            al.d(bVar.fjL, d.C0277d.cp_cont_c, 1);
            al.d(bVar.fjM, d.C0277d.cp_link_tip_d, 1);
            bVar.fjN.dU(!bVar.fjN.isEnabled());
        }
    }

    public void hide() {
        this.fjz.setVisibility(8);
    }

    public void show() {
        this.fjz.setVisibility(0);
    }
}
