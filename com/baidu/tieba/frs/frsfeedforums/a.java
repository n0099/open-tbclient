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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ae {
    private LikeModel bvr;
    private boolean dnO;
    private View dnT;
    private View dqn;
    private LinearLayout dqp;
    private TextView dqq;
    private ImageView dqr;
    private TextView dqs;
    private View dqt;
    private List<FeedForumData> dqv;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dqu = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dqw = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (ba.aU(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.bvr.cj(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new am(str2).ah(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new am("c10029").ah(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != d.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dqs.getId() && w.y(a.this.dqv) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dqv)));
                    TiebaStatic.log(new am("c10046").ah(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new am(str).ah(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cSk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.tE(a.this.bvr.getErrorCode())) {
                AntiHelper.ao(a.this.mTbPageContext.getPageActivity(), a.this.bvr.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.bvr.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.bvr.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (w.y(a.this.dqv) > 0 && rVar != null) {
                    Iterator it = a.this.dqu.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dqD.getTag();
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
                                Iterator it2 = a.this.dqv.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dqv.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dqv.size() > 0) {
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

    @Override // com.baidu.tieba.frs.ae
    public void a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.dqp = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.dqn = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.dqt = view.findViewById(d.g.layout_like_feed_forum_header);
        this.dqq = (TextView) this.dqp.findViewById(d.g.like_feed_forums_label);
        this.dqr = (ImageView) this.dqp.findViewById(d.g.like_feed_forums_arrow);
        this.dqr.setOnClickListener(this.mOnClickListener);
        this.dqs = (TextView) this.dqp.findViewById(d.g.feed_forums_more);
        this.dnT = view.findViewById(d.g.feed_forum_bottom_line);
        this.dqs.setOnClickListener(this.mOnClickListener);
        this.bvr = new LikeModel(tbPageContext);
        this.bvr.setUniqueId(bdUniqueId);
        this.bvr.setLoadDataCallBack(this.cSk);
        this.mType = i;
        this.dnO = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dqv = list;
        refreshUI();
        if (this.mType == 2 && !this.dqw) {
            TiebaStatic.log(new am("c10035").ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dqw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (w.y(this.dqv) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dqv.size() > 2 ? 2 : this.dqv.size();
        int size2 = size - this.dqu.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.i.frs_header_feed_forum_item;
                } else {
                    i = d.i.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dqp.addView(inflate);
                this.dqu.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dqu.size() - 1;
                this.dqp.removeView(this.dqu.get(size3).bmp);
                this.dqu.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dqv.get(i4);
            b bVar = this.dqu.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bmp.setTag(feedForumData);
                bVar.bmp.setOnClickListener(this.mOnClickListener);
                bVar.dqA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dqA.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dqB.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.k.attention_post_count), kE(feedForumData.getMemberCount()), kE(feedForumData.getPostNum())));
                bVar.dqC.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dqD.setClickable(true);
                    bVar.dqD.setOnClickListener(this.mOnClickListener);
                    bVar.dqD.setTag(feedForumData);
                    bVar.dqD.aU(false);
                    bVar.dqD.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dnO) {
            this.dnT.setVisibility(0);
        } else {
            this.dnT.setVisibility(8);
        }
        awz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dqD != null) {
            bVar.dqD.aU(true);
            bVar.dqD.setEnabled(false);
        }
    }

    private String kE(int i) {
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
        aVar.dB(this.mTbPageContext.getPageActivity().getString(d.k.not_intrested));
        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dqv != null) {
                    a.this.dqv.clear();
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
        aVar.b(this.mTbPageContext).xa();
    }

    @Override // com.baidu.tieba.frs.ae
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            awz();
        }
        this.mSkinType = i;
    }

    private void awz() {
        al.j(this.dqp, d.C0141d.cp_bg_line_d);
        al.j(this.dqn, d.C0141d.cp_bg_line_b);
        al.j(this.dqt, d.C0141d.cp_bg_line_d);
        al.c(this.dqq, d.C0141d.cp_cont_c, 1);
        al.c(this.dqr, d.f.icon_frs_recommend_arrow_down);
        al.c(this.dqs, d.C0141d.cp_cont_e, 1);
        for (b bVar : this.dqu) {
            al.i(bVar.bmp, d.f.frs_like_feed_forum_item_bg);
            al.c(bVar.mTitle, d.C0141d.cp_cont_b, 1);
            al.c(bVar.dqB, d.C0141d.cp_cont_c, 1);
            al.c(bVar.dqC, d.C0141d.cp_link_tip_d, 1);
            bVar.dqD.aU(!bVar.dqD.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void hide() {
        this.dqp.setVisibility(8);
    }

    public void show() {
        this.dqp.setVisibility(0);
    }
}
