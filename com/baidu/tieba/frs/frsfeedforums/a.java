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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private LikeModel cer;
    private boolean fEq;
    private View fEv;
    private View fHg;
    private LinearLayout fHi;
    private TextView fHj;
    private ImageView fHk;
    private TextView fHl;
    private View fHm;
    private List<FeedForumData> fHo;
    TbPageContext<FrsFragment> mTbPageContext;
    private List<b> fHn = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean fHp = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bc.cF(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.cer.em(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).bT("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").bT("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.fHl.getId() && v.Z(a.this.fHo) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.fHo)));
                    TiebaStatic.log(new an("c10046").bT("fid", a.this.mForumId));
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
                    TiebaStatic.log(new an(str).bT("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d eZj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(a.this.cer.getErrorCode(), a.this.cer.getErrorString())) {
                AntiHelper.aQ(a.this.mTbPageContext.getPageActivity(), a.this.cer.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.cer.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.cer.getErrorString());
                }
            } else {
                final t tVar = (t) obj;
                if (v.Z(a.this.fHo) > 0 && tVar != null) {
                    Iterator it = a.this.fHn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.fHw.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(tVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.fHo.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(tVar.getFid())) {
                                        a.this.fHo.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.fHo.size() > 0) {
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
        this.fHi = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.fHg = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.fHm = view.findViewById(R.id.layout_like_feed_forum_header);
        this.fHj = (TextView) this.fHi.findViewById(R.id.like_feed_forums_label);
        this.fHk = (ImageView) this.fHi.findViewById(R.id.like_feed_forums_arrow);
        this.fHk.setOnClickListener(this.mOnClickListener);
        this.fHl = (TextView) this.fHi.findViewById(R.id.feed_forums_more);
        this.fEv = view.findViewById(R.id.feed_forum_bottom_line);
        this.fHl.setOnClickListener(this.mOnClickListener);
        this.cer = new LikeModel(tbPageContext);
        this.cer.setUniqueId(bdUniqueId);
        this.cer.setLoadDataCallBack(this.eZj);
        this.mType = i;
        this.fEq = z;
    }

    public void e(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.fHo = list;
        refreshUI();
        if (this.mType == 2 && !this.fHp) {
            TiebaStatic.log(new an("c10035").bT("fid", this.mForumId));
            this.fHp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.Z(this.fHo) == 0) {
            hide();
            return;
        }
        show();
        int size = this.fHo.size() > 2 ? 2 : this.fHo.size();
        int size2 = size - this.fHn.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.fHi.addView(inflate);
                this.fHn.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.fHn.size() - 1;
                this.fHi.removeView(this.fHn.get(size3).cZX);
                this.fHn.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.fHo.get(i4);
            b bVar = this.fHn.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.cZX.setTag(feedForumData);
                bVar.cZX.setOnClickListener(this.mOnClickListener);
                bVar.fHt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.fHt.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.fHu.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), sg(feedForumData.getMemberCount()), sg(feedForumData.getPostNum())));
                bVar.fHv.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.fHw.setClickable(true);
                    bVar.fHw.setOnClickListener(this.mOnClickListener);
                    bVar.fHw.setTag(feedForumData);
                    bVar.fHw.ey(false);
                    bVar.fHw.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.fEq) {
            this.fEv.setVisibility(0);
        } else {
            this.fEv.setVisibility(8);
        }
        bqt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.fHw != null) {
            bVar.fHw.ey(true);
            bVar.fHw.setEnabled(false);
        }
    }

    private String sg(int i) {
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
        aVar.mQ(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.fHo != null) {
                    a.this.fHo.clear();
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
        aVar.b(this.mTbPageContext).agO();
    }

    private void bqt() {
        am.l(this.fHi, R.color.cp_bg_line_d);
        am.l(this.fHg, R.color.cp_bg_line_c);
        am.l(this.fHm, R.color.cp_bg_line_d);
        am.f(this.fHj, R.color.cp_cont_c, 1);
        am.c(this.fHk, (int) R.drawable.icon_frs_recommend_arrow_down);
        am.f(this.fHl, R.color.cp_cont_e, 1);
        for (b bVar : this.fHn) {
            am.k(bVar.cZX, R.drawable.frs_like_feed_forum_item_bg);
            am.f(bVar.mTitle, R.color.cp_cont_b, 1);
            am.f(bVar.fHu, R.color.cp_cont_c, 1);
            am.f(bVar.fHv, R.color.cp_link_tip_d, 1);
            bVar.fHw.ey(!bVar.fHw.isEnabled());
        }
    }

    public void hide() {
        this.fHi.setVisibility(8);
    }

    public void show() {
        this.fHi.setVisibility(0);
    }
}
