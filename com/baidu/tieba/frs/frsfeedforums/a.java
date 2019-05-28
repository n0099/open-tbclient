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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
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
    private LikeModel ccn;
    private boolean fwT;
    private View fwY;
    private View fzF;
    private LinearLayout fzH;
    private TextView fzI;
    private ImageView fzJ;
    private TextView fzK;
    private View fzL;
    private List<FeedForumData> fzN;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> fzM = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean fzO = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bc.cE(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.ccn.ek(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new am(str2).bT("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new am("c10029").bT("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.fzK.getId() && v.Z(a.this.fzN) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.fzN)));
                    TiebaStatic.log(new am("c10046").bT("fid", a.this.mForumId));
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
                    TiebaStatic.log(new am(str).bT("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d eSt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.ccn.getErrorCode(), a.this.ccn.getErrorString())) {
                AntiHelper.aI(a.this.mTbPageContext.getPageActivity(), a.this.ccn.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.ccn.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.ccn.getErrorString());
                }
            } else {
                final r rVar = (r) obj;
                if (v.Z(a.this.fzN) > 0 && rVar != null) {
                    Iterator it = a.this.fzM.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.fzV.getTag();
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
                                Iterator it2 = a.this.fzN.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(rVar.getFid())) {
                                        a.this.fzN.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.fzN.size() > 0) {
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
        this.fzH = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.fzF = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.fzL = view.findViewById(R.id.layout_like_feed_forum_header);
        this.fzI = (TextView) this.fzH.findViewById(R.id.like_feed_forums_label);
        this.fzJ = (ImageView) this.fzH.findViewById(R.id.like_feed_forums_arrow);
        this.fzJ.setOnClickListener(this.mOnClickListener);
        this.fzK = (TextView) this.fzH.findViewById(R.id.feed_forums_more);
        this.fwY = view.findViewById(R.id.feed_forum_bottom_line);
        this.fzK.setOnClickListener(this.mOnClickListener);
        this.ccn = new LikeModel(tbPageContext);
        this.ccn.setUniqueId(bdUniqueId);
        this.ccn.setLoadDataCallBack(this.eSt);
        this.mType = i;
        this.fwT = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.fzN = list;
        refreshUI();
        if (this.mType == 2 && !this.fzO) {
            TiebaStatic.log(new am("c10035").bT("fid", this.mForumId));
            this.fzO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.Z(this.fzN) == 0) {
            hide();
            return;
        }
        show();
        int size = this.fzN.size() > 2 ? 2 : this.fzN.size();
        int size2 = size - this.fzM.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.fzH.addView(inflate);
                this.fzM.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.fzM.size() - 1;
                this.fzH.removeView(this.fzM.get(size3).cWI);
                this.fzM.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.fzN.get(i4);
            b bVar = this.fzM.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.cWI.setTag(feedForumData);
                bVar.cWI.setOnClickListener(this.mOnClickListener);
                bVar.fzS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.fzS.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.fzT.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), rI(feedForumData.getMemberCount()), rI(feedForumData.getPostNum())));
                bVar.fzU.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.fzV.setClickable(true);
                    bVar.fzV.setOnClickListener(this.mOnClickListener);
                    bVar.fzV.setTag(feedForumData);
                    bVar.fzV.er(false);
                    bVar.fzV.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.fwT) {
            this.fwY.setVisibility(0);
        } else {
            this.fwY.setVisibility(8);
        }
        bnt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.fzV != null) {
            bVar.fzV.er(true);
            bVar.fzV.setEnabled(false);
        }
    }

    private String rI(int i) {
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
        aVar.mE(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.fzN != null) {
                    a.this.fzN.clear();
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
        aVar.b(this.mTbPageContext).afG();
    }

    private void bnt() {
        al.l(this.fzH, R.color.cp_bg_line_d);
        al.l(this.fzF, R.color.cp_bg_line_b);
        al.l(this.fzL, R.color.cp_bg_line_d);
        al.f(this.fzI, R.color.cp_cont_c, 1);
        al.c(this.fzJ, (int) R.drawable.icon_frs_recommend_arrow_down);
        al.f(this.fzK, R.color.cp_cont_e, 1);
        for (b bVar : this.fzM) {
            al.k(bVar.cWI, R.drawable.frs_like_feed_forum_item_bg);
            al.f(bVar.mTitle, R.color.cp_cont_b, 1);
            al.f(bVar.fzT, R.color.cp_cont_c, 1);
            al.f(bVar.fzU, R.color.cp_link_tip_d, 1);
            bVar.fzV.er(!bVar.fzV.isEnabled());
        }
    }

    public void hide() {
        this.fzH.setVisibility(8);
    }

    public void show() {
        this.fzH.setVisibility(0);
    }
}
