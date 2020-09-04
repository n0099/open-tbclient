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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private LikeModel exb;
    private boolean icW;
    private View idb;
    private View igV;
    private LinearLayout igX;
    private ImageView igY;
    private TextView igZ;
    private View iha;
    private List<FeedForumData> ihc;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> ihb = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean ihd = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bg.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.exb.fR(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new aq(str2).dD("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.Nv();
                TiebaStatic.log(new aq("c10029").dD("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.igZ.getId() && y.getCount(a.this.ihc) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.ihc)));
                    TiebaStatic.log(new aq("c10046").dD("fid", a.this.mForumId));
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
                    TiebaStatic.log(new aq(str).dD("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hvA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.by(a.this.exb.getErrorCode(), a.this.exb.getErrorString())) {
                AntiHelper.bb(a.this.mTbPageContext.getPageActivity(), a.this.exb.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.exb.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.exb.getErrorString());
                }
            } else {
                final v vVar = (v) obj;
                if (y.getCount(a.this.ihc) > 0 && vVar != null) {
                    Iterator it = a.this.ihb.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.ihk.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(vVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.ihc.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(vVar.getFid())) {
                                        a.this.ihc.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.ihc.size() > 0) {
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
        this.igX = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.igV = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.iha = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.igX.findViewById(R.id.like_feed_forums_label);
        this.igY = (ImageView) this.igX.findViewById(R.id.like_feed_forums_arrow);
        this.igY.setOnClickListener(this.mOnClickListener);
        this.igZ = (TextView) this.igX.findViewById(R.id.feed_forums_more);
        this.idb = view.findViewById(R.id.feed_forum_bottom_line);
        this.igZ.setOnClickListener(this.mOnClickListener);
        this.exb = new LikeModel(tbPageContext);
        this.exb.setUniqueId(bdUniqueId);
        this.exb.setLoadDataCallBack(this.hvA);
        this.mType = i;
        this.icW = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.ihc = list;
        refreshUI();
        if (this.mType == 2 && !this.ihd) {
            TiebaStatic.log(new aq("c10035").dD("fid", this.mForumId));
            this.ihd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.ihc) == 0) {
            hide();
            return;
        }
        show();
        int size = this.ihc.size() > 2 ? 2 : this.ihc.size();
        int size2 = size - this.ihb.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.igX.addView(inflate);
                this.ihb.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.ihb.size() - 1;
                this.igX.removeView(this.ihb.get(size3).fpR);
                this.ihb.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.ihc.get(i4);
            b bVar = this.ihb.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.fpR.setTag(feedForumData);
                bVar.fpR.setOnClickListener(this.mOnClickListener);
                bVar.ihh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.ihh.setPlaceHolder(1);
                bVar.ihh.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.ihi.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), xQ(feedForumData.getMemberCount()), xQ(feedForumData.getPostNum())));
                bVar.ihj.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.ihk.setClickable(true);
                    bVar.ihk.setOnClickListener(this.mOnClickListener);
                    bVar.ihk.setTag(feedForumData);
                    bVar.ihk.aN(false);
                    bVar.ihk.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.icW) {
            this.idb.setVisibility(0);
        } else {
            this.idb.setVisibility(8);
        }
        cqi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.ihk != null) {
            bVar.ihk.aN(true);
            bVar.ihk.setEnabled(false);
        }
    }

    private String xQ(int i) {
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
    public void Nv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.zA(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.ihc != null) {
                    a.this.ihc.clear();
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
        aVar.b(this.mTbPageContext).bhg();
    }

    private void cqi() {
        ap.setBackgroundColor(this.igX, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.igV, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iha, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ap.setImageResource(this.igY, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.igZ, R.color.cp_cont_e, 1);
        for (b bVar : this.ihb) {
            ap.setBackgroundResource(bVar.fpR, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.ihi, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.ihj, R.color.cp_link_tip_d, 1);
            bVar.ihk.aN(!bVar.ihk.isEnabled());
        }
    }

    public void hide() {
        this.igX.setVisibility(8);
    }

    public void show() {
        this.igX.setVisibility(0);
    }
}
