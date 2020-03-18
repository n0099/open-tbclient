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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private LikeModel dku;
    private View gAA;
    private List<FeedForumData> gAC;
    private View gAv;
    private LinearLayout gAx;
    private ImageView gAy;
    private TextView gAz;
    private boolean gxq;
    private View gxv;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> gAB = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean gAD = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bc.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.dku.eA(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).cx("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").cx("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.gAz.getId() && v.getCount(a.this.gAC) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.gAC)));
                    TiebaStatic.log(new an("c10046").cx("fid", a.this.mForumId));
                }
            } else {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str3 = "";
                    if (a.this.mType == 1) {
                        str3 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str3)));
                    if (a.this.mType == 2) {
                        str = "c10042";
                    } else {
                        str = "c10030";
                    }
                    TiebaStatic.log(new an(str).cx("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d fWi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(a.this.dku.getErrorCode(), a.this.dku.getErrorString())) {
                AntiHelper.bn(a.this.mTbPageContext.getPageActivity(), a.this.dku.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.dku.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.dku.getErrorString());
                }
            } else {
                final u uVar = (u) obj;
                if (v.getCount(a.this.gAC) > 0 && uVar != null) {
                    Iterator it = a.this.gAB.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.gAK.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(uVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.gAC.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(uVar.getFid())) {
                                        a.this.gAC.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.gAC.size() > 0) {
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
        this.gAx = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.gAv = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.gAA = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.gAx.findViewById(R.id.like_feed_forums_label);
        this.gAy = (ImageView) this.gAx.findViewById(R.id.like_feed_forums_arrow);
        this.gAy.setOnClickListener(this.mOnClickListener);
        this.gAz = (TextView) this.gAx.findViewById(R.id.feed_forums_more);
        this.gxv = view.findViewById(R.id.feed_forum_bottom_line);
        this.gAz.setOnClickListener(this.mOnClickListener);
        this.dku = new LikeModel(tbPageContext);
        this.dku.setUniqueId(bdUniqueId);
        this.dku.setLoadDataCallBack(this.fWi);
        this.mType = i;
        this.gxq = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.gAC = list;
        refreshUI();
        if (this.mType == 2 && !this.gAD) {
            TiebaStatic.log(new an("c10035").cx("fid", this.mForumId));
            this.gAD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.getCount(this.gAC) == 0) {
            hide();
            return;
        }
        show();
        int size = this.gAC.size() > 2 ? 2 : this.gAC.size();
        int size2 = size - this.gAB.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.gAx.addView(inflate);
                this.gAB.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.gAB.size() - 1;
                this.gAx.removeView(this.gAB.get(size3).ebf);
                this.gAB.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.gAC.get(i4);
            b bVar = this.gAB.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.ebf.setTag(feedForumData);
                bVar.ebf.setOnClickListener(this.mOnClickListener);
                bVar.gAH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.gAH.setPlaceHolder(1);
                bVar.gAH.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.gAI.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), tv(feedForumData.getMemberCount()), tv(feedForumData.getPostNum())));
                bVar.gAJ.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.gAK.setClickable(true);
                    bVar.gAK.setOnClickListener(this.mOnClickListener);
                    bVar.gAK.setTag(feedForumData);
                    bVar.gAK.fV(false);
                    bVar.gAK.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.gxq) {
            this.gxv.setVisibility(0);
        } else {
            this.gxv.setVisibility(8);
        }
        bHM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.gAK != null) {
            bVar.gAK.fV(true);
            bVar.gAK.setEnabled(false);
        }
    }

    private String tv(int i) {
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
        aVar.sR(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.gAC != null) {
                    a.this.gAC.clear();
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
        aVar.b(this.mTbPageContext).aEG();
    }

    private void bHM() {
        am.setBackgroundColor(this.gAx, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gAv, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gAA, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        am.setImageResource(this.gAy, R.drawable.icon_frs_recommend_arrow_down);
        am.setViewTextColor(this.gAz, R.color.cp_cont_e, 1);
        for (b bVar : this.gAB) {
            am.setBackgroundResource(bVar.ebf, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.gAI, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.gAJ, R.color.cp_link_tip_d, 1);
            bVar.gAK.fV(!bVar.gAK.isEnabled());
        }
    }

    public void hide() {
        this.gAx.setVisibility(8);
    }

    public void show() {
        this.gAx.setVisibility(0);
    }
}
