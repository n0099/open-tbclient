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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
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
    private LikeModel aLn;
    private boolean dSL;
    private View dSQ;
    private View dVo;
    private LinearLayout dVq;
    private TextView dVr;
    private ImageView dVs;
    private TextView dVt;
    private View dVu;
    private List<FeedForumData> dVw;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dVv = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dVx = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == e.g.frs_feed_forum_attention) {
                if (ba.bJ(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.aLn.cK(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new am(str2).aA(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == e.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new am("c10029").aA(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != e.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dVt.getId() && v.H(a.this.dVw) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dVw)));
                    TiebaStatic.log(new am("c10046").aA(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new am(str).aA(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d drB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aj(a.this.aLn.getErrorCode(), a.this.aLn.getErrorString())) {
                AntiHelper.aJ(a.this.mTbPageContext.getPageActivity(), a.this.aLn.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.aLn.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.aLn.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.H(a.this.dVw) > 0 && rVar != null) {
                    Iterator it = a.this.dVv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dVE.getTag();
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
                                Iterator it2 = a.this.dVw.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dVw.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dVw.size() > 0) {
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
        this.dVq = (LinearLayout) view.findViewById(e.g.frs_header_feed_forums);
        this.dVo = view.findViewById(e.g.frs_header_feed_forums_divider);
        this.dVu = view.findViewById(e.g.layout_like_feed_forum_header);
        this.dVr = (TextView) this.dVq.findViewById(e.g.like_feed_forums_label);
        this.dVs = (ImageView) this.dVq.findViewById(e.g.like_feed_forums_arrow);
        this.dVs.setOnClickListener(this.mOnClickListener);
        this.dVt = (TextView) this.dVq.findViewById(e.g.feed_forums_more);
        this.dSQ = view.findViewById(e.g.feed_forum_bottom_line);
        this.dVt.setOnClickListener(this.mOnClickListener);
        this.aLn = new LikeModel(tbPageContext);
        this.aLn.setUniqueId(bdUniqueId);
        this.aLn.setLoadDataCallBack(this.drB);
        this.mType = i;
        this.dSL = z;
    }

    public void e(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dVw = list;
        refreshUI();
        if (this.mType == 2 && !this.dVx) {
            TiebaStatic.log(new am("c10035").aA(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dVx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.H(this.dVw) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dVw.size() > 2 ? 2 : this.dVw.size();
        int size2 = size - this.dVv.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = e.h.frs_header_feed_forum_item;
                } else {
                    i = e.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dVq.addView(inflate);
                this.dVv.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dVv.size() - 1;
                this.dVq.removeView(this.dVv.get(size3).bCB);
                this.dVv.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dVw.get(i4);
            b bVar = this.dVv.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bCB.setTag(feedForumData);
                bVar.bCB.setOnClickListener(this.mOnClickListener);
                bVar.dVB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dVB.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dVC.setText(String.format(this.mTbPageContext.getPageActivity().getString(e.j.attention_post_count), mQ(feedForumData.getMemberCount()), mQ(feedForumData.getPostNum())));
                bVar.dVD.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dVE.setClickable(true);
                    bVar.dVE.setOnClickListener(this.mOnClickListener);
                    bVar.dVE.setTag(feedForumData);
                    bVar.dVE.bK(false);
                    bVar.dVE.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dSL) {
            this.dSQ.setVisibility(0);
        } else {
            this.dSQ.setVisibility(8);
        }
        aFk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dVE != null) {
            bVar.dVE.bK(true);
            bVar.dVE.setEnabled(false);
        }
    }

    private String mQ(int i) {
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
        aVar.eB(this.mTbPageContext.getPageActivity().getString(e.j.not_intrested));
        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dVw != null) {
                    a.this.dVw.clear();
                }
                a.this.hide();
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mTbPageContext).BF();
    }

    @Override // com.baidu.tieba.frs.ag
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            aFk();
        }
        this.mSkinType = i;
    }

    private void aFk() {
        al.j(this.dVq, e.d.cp_bg_line_d);
        al.j(this.dVo, e.d.cp_bg_line_b);
        al.j(this.dVu, e.d.cp_bg_line_d);
        al.c(this.dVr, e.d.cp_cont_c, 1);
        al.c(this.dVs, e.f.icon_frs_recommend_arrow_down);
        al.c(this.dVt, e.d.cp_cont_e, 1);
        for (b bVar : this.dVv) {
            al.i(bVar.bCB, e.f.frs_like_feed_forum_item_bg);
            al.c(bVar.mTitle, e.d.cp_cont_b, 1);
            al.c(bVar.dVC, e.d.cp_cont_c, 1);
            al.c(bVar.dVD, e.d.cp_link_tip_d, 1);
            bVar.dVE.bK(!bVar.dVE.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void hide() {
        this.dVq.setVisibility(8);
    }

    public void show() {
        this.dVq.setVisibility(0);
    }
}
