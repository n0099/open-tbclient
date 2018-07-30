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
import com.baidu.tbadk.core.util.ba;
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
    private LikeModel azq;
    private boolean dtK;
    private View dtP;
    private View dwj;
    private LinearLayout dwl;
    private TextView dwm;
    private ImageView dwn;
    private TextView dwo;
    private View dwp;
    private List<FeedForumData> dwr;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dwq = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dws = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == d.g.frs_feed_forum_attention) {
                if (ba.aV(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.azq.ck(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).af(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == d.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").af(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != d.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dwo.getId() && w.y(a.this.dwr) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dwr)));
                    TiebaStatic.log(new an("c10046").af(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new an(str).af(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cSU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.al(a.this.azq.getErrorCode(), a.this.azq.getErrorString())) {
                AntiHelper.aq(a.this.mTbPageContext.getPageActivity(), a.this.azq.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.azq.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.azq.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (w.y(a.this.dwr) > 0 && rVar != null) {
                    Iterator it = a.this.dwq.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dwz.getTag();
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
                                Iterator it2 = a.this.dwr.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dwr.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dwr.size() > 0) {
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
        this.dwl = (LinearLayout) view.findViewById(d.g.frs_header_feed_forums);
        this.dwj = view.findViewById(d.g.frs_header_feed_forums_divider);
        this.dwp = view.findViewById(d.g.layout_like_feed_forum_header);
        this.dwm = (TextView) this.dwl.findViewById(d.g.like_feed_forums_label);
        this.dwn = (ImageView) this.dwl.findViewById(d.g.like_feed_forums_arrow);
        this.dwn.setOnClickListener(this.mOnClickListener);
        this.dwo = (TextView) this.dwl.findViewById(d.g.feed_forums_more);
        this.dtP = view.findViewById(d.g.feed_forum_bottom_line);
        this.dwo.setOnClickListener(this.mOnClickListener);
        this.azq = new LikeModel(tbPageContext);
        this.azq.setUniqueId(bdUniqueId);
        this.azq.setLoadDataCallBack(this.cSU);
        this.mType = i;
        this.dtK = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dwr = list;
        refreshUI();
        if (this.mType == 2 && !this.dws) {
            TiebaStatic.log(new an("c10035").af(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dws = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (w.y(this.dwr) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dwr.size() > 2 ? 2 : this.dwr.size();
        int size2 = size - this.dwq.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = d.h.frs_header_feed_forum_item;
                } else {
                    i = d.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dwl.addView(inflate);
                this.dwq.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dwq.size() - 1;
                this.dwl.removeView(this.dwq.get(size3).bou);
                this.dwq.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dwr.get(i4);
            b bVar = this.dwq.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bou.setTag(feedForumData);
                bVar.bou.setOnClickListener(this.mOnClickListener);
                bVar.dww.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dww.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dwx.setText(String.format(this.mTbPageContext.getPageActivity().getString(d.j.attention_post_count), kW(feedForumData.getMemberCount()), kW(feedForumData.getPostNum())));
                bVar.dwy.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dwz.setClickable(true);
                    bVar.dwz.setOnClickListener(this.mOnClickListener);
                    bVar.dwz.setTag(feedForumData);
                    bVar.dwz.aV(false);
                    bVar.dwz.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dtK) {
            this.dtP.setVisibility(0);
        } else {
            this.dtP.setVisibility(8);
        }
        axI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dwz != null) {
            bVar.dwz.aV(true);
            bVar.dwz.setEnabled(false);
        }
    }

    private String kW(int i) {
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
        aVar.dB(this.mTbPageContext.getPageActivity().getString(d.j.not_intrested));
        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dwr != null) {
                    a.this.dwr.clear();
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
        aVar.b(this.mTbPageContext).xf();
    }

    @Override // com.baidu.tieba.frs.ag
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            axI();
        }
        this.mSkinType = i;
    }

    private void axI() {
        am.j(this.dwl, d.C0140d.cp_bg_line_d);
        am.j(this.dwj, d.C0140d.cp_bg_line_b);
        am.j(this.dwp, d.C0140d.cp_bg_line_d);
        am.c(this.dwm, d.C0140d.cp_cont_c, 1);
        am.c(this.dwn, d.f.icon_frs_recommend_arrow_down);
        am.c(this.dwo, d.C0140d.cp_cont_e, 1);
        for (b bVar : this.dwq) {
            am.i(bVar.bou, d.f.frs_like_feed_forum_item_bg);
            am.c(bVar.mTitle, d.C0140d.cp_cont_b, 1);
            am.c(bVar.dwx, d.C0140d.cp_cont_c, 1);
            am.c(bVar.dwy, d.C0140d.cp_link_tip_d, 1);
            bVar.dwz.aV(!bVar.dwz.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void hide() {
        this.dwl.setVisibility(8);
    }

    public void show() {
        this.dwl.setVisibility(0);
    }
}
