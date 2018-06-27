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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ag {
    private LikeModel bwM;
    private boolean dqX;
    private View drc;
    private ImageView dtA;
    private TextView dtB;
    private View dtC;
    private List<FeedForumData> dtE;
    private View dtw;
    private LinearLayout dty;
    private TextView dtz;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dtD = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dtF = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (bb.aU(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.bwM.cn(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).ah(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").ah(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != d.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dtB.getId() && w.z(a.this.dtE) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dtE)));
                    TiebaStatic.log(new an("c10046").ah(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new an(str).ah(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cQi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.tQ(a.this.bwM.getErrorCode())) {
                AntiHelper.ao(a.this.mTbPageContext.getPageActivity(), a.this.bwM.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.bwM.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.bwM.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (w.z(a.this.dtE) > 0 && rVar != null) {
                    Iterator it = a.this.dtD.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dtM.getTag();
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
                                Iterator it2 = a.this.dtE.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dtE.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dtE.size() > 0) {
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

    @Override // com.baidu.tieba.frs.ag
    public void a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.dty = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.dtw = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.dtC = view.findViewById(d.g.layout_like_feed_forum_header);
        this.dtz = (TextView) this.dty.findViewById(d.g.like_feed_forums_label);
        this.dtA = (ImageView) this.dty.findViewById(d.g.like_feed_forums_arrow);
        this.dtA.setOnClickListener(this.mOnClickListener);
        this.dtB = (TextView) this.dty.findViewById(d.g.feed_forums_more);
        this.drc = view.findViewById(d.g.feed_forum_bottom_line);
        this.dtB.setOnClickListener(this.mOnClickListener);
        this.bwM = new LikeModel(tbPageContext);
        this.bwM.setUniqueId(bdUniqueId);
        this.bwM.setLoadDataCallBack(this.cQi);
        this.mType = i;
        this.dqX = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dtE = list;
        refreshUI();
        if (this.mType == 2 && !this.dtF) {
            TiebaStatic.log(new an("c10035").ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dtF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (w.z(this.dtE) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dtE.size() > 2 ? 2 : this.dtE.size();
        int size2 = size - this.dtD.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.i.frs_header_feed_forum_item;
                } else {
                    i = d.i.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dty.addView(inflate);
                this.dtD.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dtD.size() - 1;
                this.dty.removeView(this.dtD.get(size3).bnO);
                this.dtD.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dtE.get(i4);
            b bVar = this.dtD.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bnO.setTag(feedForumData);
                bVar.bnO.setOnClickListener(this.mOnClickListener);
                bVar.dtJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dtJ.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dtK.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.k.attention_post_count), kL(feedForumData.getMemberCount()), kL(feedForumData.getPostNum())));
                bVar.dtL.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dtM.setClickable(true);
                    bVar.dtM.setOnClickListener(this.mOnClickListener);
                    bVar.dtM.setTag(feedForumData);
                    bVar.dtM.aX(false);
                    bVar.dtM.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dqX) {
            this.drc.setVisibility(0);
        } else {
            this.drc.setVisibility(8);
        }
        axd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dtM != null) {
            bVar.dtM.aX(true);
            bVar.dtM.setEnabled(false);
        }
    }

    private String kL(int i) {
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
        aVar.dE(this.mTbPageContext.getPageActivity().getString(d.k.not_intrested));
        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dtE != null) {
                    a.this.dtE.clear();
                }
                a.this.hide();
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mTbPageContext).xn();
    }

    @Override // com.baidu.tieba.frs.ag
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            axd();
        }
        this.mSkinType = i;
    }

    private void axd() {
        am.j(this.dty, d.C0142d.cp_bg_line_d);
        am.j(this.dtw, d.C0142d.cp_bg_line_b);
        am.j(this.dtC, d.C0142d.cp_bg_line_d);
        am.c(this.dtz, d.C0142d.cp_cont_c, 1);
        am.c(this.dtA, d.f.icon_frs_recommend_arrow_down);
        am.c(this.dtB, d.C0142d.cp_cont_e, 1);
        for (b bVar : this.dtD) {
            am.i(bVar.bnO, d.f.frs_like_feed_forum_item_bg);
            am.c(bVar.mTitle, d.C0142d.cp_cont_b, 1);
            am.c(bVar.dtK, d.C0142d.cp_cont_c, 1);
            am.c(bVar.dtL, d.C0142d.cp_link_tip_d, 1);
            bVar.dtM.aX(!bVar.dtM.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void hide() {
        this.dty.setVisibility(8);
    }

    public void show() {
        this.dty.setVisibility(0);
    }
}
