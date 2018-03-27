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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ai {
    private LikeModel ccX;
    private boolean dKt;
    private View dKy;
    private View dNn;
    private LinearLayout dNp;
    private TextView dNq;
    private ImageView dNr;
    private TextView dNs;
    private View dNt;
    private List<FeedForumData> dNv;
    TbPageContext<i> mTbPageContext;
    private List<b> dNu = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dNw = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (ay.ba(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.ccX.cc(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ak(str2).ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new ak("c10029").ab(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != d.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dNs.getId() && v.D(a.this.dNv) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dNv)));
                    TiebaStatic.log(new ak("c10046").ab(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new ak(str).ab(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d dpG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vR(a.this.ccX.getErrorCode())) {
                AntiHelper.ar(a.this.mTbPageContext.getPageActivity(), a.this.ccX.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.ccX.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.ccX.getErrorString());
                }
            } else {
                final s sVar = (s) obj;
                if (v.D(a.this.dNv) > 0 && sVar != null) {
                    Iterator it = a.this.dNu.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dND.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(sVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.dNv.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(sVar.getFid())) {
                                        a.this.dNv.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dNv.size() > 0) {
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

    @Override // com.baidu.tieba.frs.ai
    public void a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.dNp = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.dNn = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.dNt = view.findViewById(d.g.layout_like_feed_forum_header);
        this.dNq = (TextView) this.dNp.findViewById(d.g.like_feed_forums_label);
        this.dNr = (ImageView) this.dNp.findViewById(d.g.like_feed_forums_arrow);
        this.dNr.setOnClickListener(this.mOnClickListener);
        this.dNs = (TextView) this.dNp.findViewById(d.g.feed_forums_more);
        this.dKy = view.findViewById(d.g.feed_forum_bottom_line);
        this.dNs.setOnClickListener(this.mOnClickListener);
        this.ccX = new LikeModel(tbPageContext);
        this.ccX.setUniqueId(bdUniqueId);
        this.ccX.setLoadDataCallBack(this.dpG);
        this.mType = i;
        this.dKt = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dNv = list;
        refreshUI();
        if (this.mType == 2 && !this.dNw) {
            TiebaStatic.log(new ak("c10035").ab(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dNw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.D(this.dNv) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dNv.size() > 2 ? 2 : this.dNv.size();
        int size2 = size - this.dNu.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.h.frs_header_feed_forum_item;
                } else {
                    i = d.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dNp.addView(inflate);
                this.dNu.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dNu.size() - 1;
                this.dNp.removeView(this.dNu.get(size3).bUb);
                this.dNu.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dNv.get(i4);
            b bVar = this.dNu.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bUb.setTag(feedForumData);
                bVar.bUb.setOnClickListener(this.mOnClickListener);
                bVar.dNA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dNA.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dNB.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.j.attention_post_count), nn(feedForumData.getMemberCount()), nn(feedForumData.getPostNum())));
                bVar.dNC.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dND.setClickable(true);
                    bVar.dND.setOnClickListener(this.mOnClickListener);
                    bVar.dND.setTag(feedForumData);
                    bVar.dND.bz(false);
                    bVar.dND.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dKt) {
            this.dKy.setVisibility(0);
        } else {
            this.dKy.setVisibility(8);
        }
        axQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dND != null) {
            bVar.dND.bz(true);
            bVar.dND.setEnabled(false);
        }
    }

    private String nn(int i) {
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
        aVar.dk(this.mTbPageContext.getPageActivity().getString(d.j.not_intrested));
        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dNv != null) {
                    a.this.dNv.clear();
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
        aVar.b(this.mTbPageContext).AV();
    }

    @Override // com.baidu.tieba.frs.ai
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            axQ();
        }
        this.mSkinType = i;
    }

    private void axQ() {
        aj.t(this.dNp, d.C0141d.cp_bg_line_d);
        aj.t(this.dNn, d.C0141d.cp_bg_line_b);
        aj.t(this.dNt, d.C0141d.cp_bg_line_d);
        aj.e(this.dNq, d.C0141d.cp_cont_c, 1);
        aj.c(this.dNr, d.f.icon_frs_recommend_arrow_down);
        aj.e(this.dNs, d.C0141d.cp_cont_e, 1);
        for (b bVar : this.dNu) {
            aj.s(bVar.bUb, d.f.frs_like_feed_forum_item_bg);
            aj.e(bVar.mTitle, d.C0141d.cp_cont_b, 1);
            aj.e(bVar.dNB, d.C0141d.cp_cont_c, 1);
            aj.e(bVar.dNC, d.C0141d.cp_link_tip_d, 1);
            bVar.dND.bz(!bVar.dND.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void hide() {
        this.dNp.setVisibility(8);
    }

    public void show() {
        this.dNp.setVisibility(0);
    }
}
