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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
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
    private LikeModel bmW;
    private View ddA;
    private boolean ddv;
    private View dfU;
    private LinearLayout dfW;
    private TextView dfX;
    private ImageView dfY;
    private TextView dfZ;
    private View dga;
    private List<FeedForumData> dgc;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dgb = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dgd = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view2.getId() == d.g.frs_feed_forum_attention) {
                if (az.aK(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view2.getTag()) != null) {
                    a.this.bmW.cb(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new al(str2).ac(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view2.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new al("c10029").ac(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view2.getId() != d.g.frs_like_feed_forum_item) {
                if (view2.getId() == a.this.dfZ.getId() && v.v(a.this.dgc) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dgc)));
                    TiebaStatic.log(new al("c10046").ac(ImageViewerConfig.FORUM_ID, a.this.mForumId));
                }
            } else {
                FeedForumData feedForumData2 = (FeedForumData) view2.getTag();
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
                    TiebaStatic.log(new al(str).ac(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cHY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tt(a.this.bmW.getErrorCode())) {
                AntiHelper.am(a.this.mTbPageContext.getPageActivity(), a.this.bmW.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.bmW.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.bmW.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.v(a.this.dgc) > 0 && rVar != null) {
                    Iterator it = a.this.dgb.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dgk.getTag();
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
                                Iterator it2 = a.this.dgc.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dgc.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dgc.size() > 0) {
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

    public a(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        a(tbPageContext, view2, i, z, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.ae
    public void a(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.dfW = (LinearLayout) view2.findViewById(d.g.frs_header_feed_forums);
        this.dfU = view2.findViewById(d.g.frs_header_feed_forums_divider);
        this.dga = view2.findViewById(d.g.layout_like_feed_forum_header);
        this.dfX = (TextView) this.dfW.findViewById(d.g.like_feed_forums_label);
        this.dfY = (ImageView) this.dfW.findViewById(d.g.like_feed_forums_arrow);
        this.dfY.setOnClickListener(this.mOnClickListener);
        this.dfZ = (TextView) this.dfW.findViewById(d.g.feed_forums_more);
        this.ddA = view2.findViewById(d.g.feed_forum_bottom_line);
        this.dfZ.setOnClickListener(this.mOnClickListener);
        this.bmW = new LikeModel(tbPageContext);
        this.bmW.setUniqueId(bdUniqueId);
        this.bmW.setLoadDataCallBack(this.cHY);
        this.mType = i;
        this.ddv = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dgc = list;
        refreshUI();
        if (this.mType == 2 && !this.dgd) {
            TiebaStatic.log(new al("c10035").ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dgd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.v(this.dgc) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dgc.size() > 2 ? 2 : this.dgc.size();
        int size2 = size - this.dgb.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.i.frs_header_feed_forum_item;
                } else {
                    i = d.i.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dfW.addView(inflate);
                this.dgb.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dgb.size() - 1;
                this.dfW.removeView(this.dgb.get(size3).bee);
                this.dgb.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dgc.get(i4);
            b bVar = this.dgb.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bee.setTag(feedForumData);
                bVar.bee.setOnClickListener(this.mOnClickListener);
                bVar.dgh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dgh.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dgi.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.k.attention_post_count), kA(feedForumData.getMemberCount()), kA(feedForumData.getPostNum())));
                bVar.dgj.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dgk.setClickable(true);
                    bVar.dgk.setOnClickListener(this.mOnClickListener);
                    bVar.dgk.setTag(feedForumData);
                    bVar.dgk.aQ(false);
                    bVar.dgk.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.ddv) {
            this.ddA.setVisibility(0);
        } else {
            this.ddA.setVisibility(8);
        }
        asu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dgk != null) {
            bVar.dgk.aQ(true);
            bVar.dgk.setEnabled(false);
        }
    }

    private String kA(int i) {
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
        aVar.dc(this.mTbPageContext.getPageActivity().getString(d.k.not_intrested));
        aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dgc != null) {
                    a.this.dgc.clear();
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
        aVar.b(this.mTbPageContext).tD();
    }

    @Override // com.baidu.tieba.frs.ae
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            asu();
        }
        this.mSkinType = i;
    }

    private void asu() {
        ak.j(this.dfW, d.C0126d.cp_bg_line_d);
        ak.j(this.dfU, d.C0126d.cp_bg_line_b);
        ak.j(this.dga, d.C0126d.cp_bg_line_d);
        ak.c(this.dfX, d.C0126d.cp_cont_c, 1);
        ak.c(this.dfY, d.f.icon_frs_recommend_arrow_down);
        ak.c(this.dfZ, d.C0126d.cp_cont_e, 1);
        for (b bVar : this.dgb) {
            ak.i(bVar.bee, d.f.frs_like_feed_forum_item_bg);
            ak.c(bVar.mTitle, d.C0126d.cp_cont_b, 1);
            ak.c(bVar.dgi, d.C0126d.cp_cont_c, 1);
            ak.c(bVar.dgj, d.C0126d.cp_link_tip_d, 1);
            bVar.dgk.aQ(!bVar.dgk.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void hide() {
        this.dfW.setVisibility(8);
    }

    public void show() {
        this.dfW.setVisibility(0);
    }
}
