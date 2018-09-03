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
import com.baidu.tieba.f;
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
    private LikeModel azn;
    private boolean dtH;
    private View dtM;
    private View dwg;
    private LinearLayout dwi;
    private TextView dwj;
    private ImageView dwk;
    private TextView dwl;
    private View dwm;
    private List<FeedForumData> dwo;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> dwn = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean dwp = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == f.g.frs_feed_forum_attention) {
                if (bb.aU(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.azn.ck(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).ae(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == f.g.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").ae(ImageViewerConfig.FORUM_ID, a.this.mForumId));
            } else if (view.getId() != f.g.frs_like_feed_forum_item) {
                if (view.getId() == a.this.dwl.getId() && w.y(a.this.dwo) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.dwo)));
                    TiebaStatic.log(new an("c10046").ae(ImageViewerConfig.FORUM_ID, a.this.mForumId));
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
                    TiebaStatic.log(new an(str).ae(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cSR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.al(a.this.azn.getErrorCode(), a.this.azn.getErrorString())) {
                AntiHelper.aq(a.this.mTbPageContext.getPageActivity(), a.this.azn.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.azn.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.azn.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (w.y(a.this.dwo) > 0 && rVar != null) {
                    Iterator it = a.this.dwn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.dww.getTag();
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
                                Iterator it2 = a.this.dwo.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.dwo.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.dwo.size() > 0) {
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
        this.dwi = (LinearLayout) view.findViewById(f.g.frs_header_feed_forums);
        this.dwg = view.findViewById(f.g.frs_header_feed_forums_divider);
        this.dwm = view.findViewById(f.g.layout_like_feed_forum_header);
        this.dwj = (TextView) this.dwi.findViewById(f.g.like_feed_forums_label);
        this.dwk = (ImageView) this.dwi.findViewById(f.g.like_feed_forums_arrow);
        this.dwk.setOnClickListener(this.mOnClickListener);
        this.dwl = (TextView) this.dwi.findViewById(f.g.feed_forums_more);
        this.dtM = view.findViewById(f.g.feed_forum_bottom_line);
        this.dwl.setOnClickListener(this.mOnClickListener);
        this.azn = new LikeModel(tbPageContext);
        this.azn.setUniqueId(bdUniqueId);
        this.azn.setLoadDataCallBack(this.cSR);
        this.mType = i;
        this.dtH = z;
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.dwo = list;
        refreshUI();
        if (this.mType == 2 && !this.dwp) {
            TiebaStatic.log(new an("c10035").ae(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.dwp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (w.y(this.dwo) == 0) {
            hide();
            return;
        }
        show();
        int size = this.dwo.size() > 2 ? 2 : this.dwo.size();
        int size2 = size - this.dwn.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = f.h.frs_header_feed_forum_item;
                } else {
                    i = f.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.dwi.addView(inflate);
                this.dwn.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.dwn.size() - 1;
                this.dwi.removeView(this.dwn.get(size3).bow);
                this.dwn.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.dwo.get(i4);
            b bVar = this.dwn.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.bow.setTag(feedForumData);
                bVar.bow.setOnClickListener(this.mOnClickListener);
                bVar.dwt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.dwt.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.dwu.setText(String.format(this.mTbPageContext.getPageActivity().getString(f.j.attention_post_count), kV(feedForumData.getMemberCount()), kV(feedForumData.getPostNum())));
                bVar.dwv.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.dww.setClickable(true);
                    bVar.dww.setOnClickListener(this.mOnClickListener);
                    bVar.dww.setTag(feedForumData);
                    bVar.dww.aW(false);
                    bVar.dww.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.dtH) {
            this.dtM.setVisibility(0);
        } else {
            this.dtM.setVisibility(8);
        }
        axG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.dww != null) {
            bVar.dww.aW(true);
            bVar.dww.setEnabled(false);
        }
    }

    private String kV(int i) {
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
        aVar.dB(this.mTbPageContext.getPageActivity().getString(f.j.not_intrested));
        aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.dwo != null) {
                    a.this.dwo.clear();
                }
                a.this.hide();
                aVar2.dismiss();
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mTbPageContext).xe();
    }

    @Override // com.baidu.tieba.frs.ag
    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            axG();
        }
        this.mSkinType = i;
    }

    private void axG() {
        am.j(this.dwi, f.d.cp_bg_line_d);
        am.j(this.dwg, f.d.cp_bg_line_b);
        am.j(this.dwm, f.d.cp_bg_line_d);
        am.c(this.dwj, f.d.cp_cont_c, 1);
        am.c(this.dwk, f.C0146f.icon_frs_recommend_arrow_down);
        am.c(this.dwl, f.d.cp_cont_e, 1);
        for (b bVar : this.dwn) {
            am.i(bVar.bow, f.C0146f.frs_like_feed_forum_item_bg);
            am.c(bVar.mTitle, f.d.cp_cont_b, 1);
            am.c(bVar.dwu, f.d.cp_cont_c, 1);
            am.c(bVar.dwv, f.d.cp_link_tip_d, 1);
            bVar.dww.aW(!bVar.dww.isEnabled());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void hide() {
        this.dwi.setVisibility(8);
    }

    public void show() {
        this.dwi.setVisibility(0);
    }
}
