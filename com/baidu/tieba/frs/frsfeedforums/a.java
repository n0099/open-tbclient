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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ai {
    private LikeModel ccU;
    private boolean dKo;
    private View dKt;
    private View dNi;
    private LinearLayout dNk;
    private TextView dNl;
    private ImageView dNm;
    private TextView dNn;
    private View dNo;
    private List<FeedForumData> dNq;
    TbPageContext<i> mTbPageContext;
    private List<b> dNp = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dNr = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (ay.ba(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.ccU.cc(feedForumData.getForumName(), feedForumData.getForumId());
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
                if (view.getId() == a.this.dNn.getId() && v.D(a.this.dNq) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dNq)));
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
    private com.baidu.adp.base.d dpD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vR(a.this.ccU.getErrorCode())) {
                AntiHelper.ar(a.this.mTbPageContext.getPageActivity(), a.this.ccU.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.ccU.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.ccU.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.D(a.this.dNq) > 0 && rVar != null) {
                    Iterator it = a.this.dNp.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dNy.getTag();
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
                                Iterator it2 = a.this.dNq.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dNq.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dNq.size() > 0) {
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
        this.dNk = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.dNi = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.dNo = view.findViewById(d.g.layout_like_feed_forum_header);
        this.dNl = (TextView) this.dNk.findViewById(d.g.like_feed_forums_label);
        this.dNm = (ImageView) this.dNk.findViewById(d.g.like_feed_forums_arrow);
        this.dNm.setOnClickListener(this.mOnClickListener);
        this.dNn = (TextView) this.dNk.findViewById(d.g.feed_forums_more);
        this.dKt = view.findViewById(d.g.feed_forum_bottom_line);
        this.dNn.setOnClickListener(this.mOnClickListener);
        this.ccU = new LikeModel(tbPageContext);
        this.ccU.setUniqueId(bdUniqueId);
        this.ccU.setLoadDataCallBack(this.dpD);
        this.mType = i;
        this.dKo = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dNq = list;
        refreshUI();
        if (this.mType == 2 && !this.dNr) {
            TiebaStatic.log(new ak("c10035").ab(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dNr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.D(this.dNq) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dNq.size() > 2 ? 2 : this.dNq.size();
        int size2 = size - this.dNp.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.h.frs_header_feed_forum_item;
                } else {
                    i = d.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dNk.addView(inflate);
                this.dNp.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dNp.size() - 1;
                this.dNk.removeView(this.dNp.get(size3).bTY);
                this.dNp.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dNq.get(i4);
            b bVar = this.dNp.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bTY.setTag(feedForumData);
                bVar.bTY.setOnClickListener(this.mOnClickListener);
                bVar.dNv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dNv.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dNw.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.j.attention_post_count), nn(feedForumData.getMemberCount()), nn(feedForumData.getPostNum())));
                bVar.dNx.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dNy.setClickable(true);
                    bVar.dNy.setOnClickListener(this.mOnClickListener);
                    bVar.dNy.setTag(feedForumData);
                    bVar.dNy.bz(false);
                    bVar.dNy.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dKo) {
            this.dKt.setVisibility(0);
        } else {
            this.dKt.setVisibility(8);
        }
        axO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dNy != null) {
            bVar.dNy.bz(true);
            bVar.dNy.setEnabled(false);
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
                if (a.this.dNq != null) {
                    a.this.dNq.clear();
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
        aVar.b(this.mTbPageContext).AU();
    }

    @Override // com.baidu.tieba.frs.ai
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            axO();
        }
        this.mSkinType = i;
    }

    private void axO() {
        aj.t(this.dNk, d.C0141d.cp_bg_line_d);
        aj.t(this.dNi, d.C0141d.cp_bg_line_b);
        aj.t(this.dNo, d.C0141d.cp_bg_line_d);
        aj.e(this.dNl, d.C0141d.cp_cont_c, 1);
        aj.c(this.dNm, d.f.icon_frs_recommend_arrow_down);
        aj.e(this.dNn, d.C0141d.cp_cont_e, 1);
        for (b bVar : this.dNp) {
            aj.s(bVar.bTY, d.f.frs_like_feed_forum_item_bg);
            aj.e(bVar.mTitle, d.C0141d.cp_cont_b, 1);
            aj.e(bVar.dNw, d.C0141d.cp_cont_c, 1);
            aj.e(bVar.dNx, d.C0141d.cp_link_tip_d, 1);
            bVar.dNy.bz(!bVar.dNy.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void hide() {
        this.dNk.setVisibility(8);
    }

    public void show() {
        this.dNk.setVisibility(0);
    }
}
