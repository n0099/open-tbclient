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
/* loaded from: classes22.dex */
public class a {
    private LikeModel eZA;
    private boolean iRq;
    private View iRv;
    private View iVj;
    private LinearLayout iVl;
    private ImageView iVm;
    private TextView iVn;
    private View iVo;
    private List<FeedForumData> iVq;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> iVp = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean iVr = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bg.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.eZA.gp(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new aq(str2).dR("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.Qj();
                TiebaStatic.log(new aq("c10029").dR("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.iVn.getId() && y.getCount(a.this.iVq) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.iVq)));
                    TiebaStatic.log(new aq("c10046").dR("fid", a.this.mForumId));
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
                    TiebaStatic.log(new aq(str).dR("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d ijY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bR(a.this.eZA.getErrorCode(), a.this.eZA.getErrorString())) {
                AntiHelper.bm(a.this.mTbPageContext.getPageActivity(), a.this.eZA.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.eZA.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.eZA.getErrorString());
                }
            } else {
                final v vVar = (v) obj;
                if (y.getCount(a.this.iVq) > 0 && vVar != null) {
                    Iterator it = a.this.iVp.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.iVy.getTag();
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
                                Iterator it2 = a.this.iVq.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(vVar.getFid())) {
                                        a.this.iVq.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.iVq.size() > 0) {
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
        this.iVl = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.iVj = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.iVo = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.iVl.findViewById(R.id.like_feed_forums_label);
        this.iVm = (ImageView) this.iVl.findViewById(R.id.like_feed_forums_arrow);
        this.iVm.setOnClickListener(this.mOnClickListener);
        this.iVn = (TextView) this.iVl.findViewById(R.id.feed_forums_more);
        this.iRv = view.findViewById(R.id.feed_forum_bottom_line);
        this.iVn.setOnClickListener(this.mOnClickListener);
        this.eZA = new LikeModel(tbPageContext);
        this.eZA.setUniqueId(bdUniqueId);
        this.eZA.setLoadDataCallBack(this.ijY);
        this.mType = i;
        this.iRq = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.iVq = list;
        refreshUI();
        if (this.mType == 2 && !this.iVr) {
            TiebaStatic.log(new aq("c10035").dR("fid", this.mForumId));
            this.iVr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.iVq) == 0) {
            hide();
            return;
        }
        show();
        int size = this.iVq.size() > 2 ? 2 : this.iVq.size();
        int size2 = size - this.iVp.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.iVl.addView(inflate);
                this.iVp.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.iVp.size() - 1;
                this.iVl.removeView(this.iVp.get(size3).fTz);
                this.iVp.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.iVq.get(i4);
            b bVar = this.iVp.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.fTz.setTag(feedForumData);
                bVar.fTz.setOnClickListener(this.mOnClickListener);
                bVar.iVv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.iVv.setPlaceHolder(1);
                bVar.iVv.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.iVw.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), zB(feedForumData.getMemberCount()), zB(feedForumData.getPostNum())));
                bVar.iVx.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.iVy.setClickable(true);
                    bVar.iVy.setOnClickListener(this.mOnClickListener);
                    bVar.iVy.setTag(feedForumData);
                    bVar.iVy.aN(false);
                    bVar.iVy.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.iRq) {
            this.iRv.setVisibility(0);
        } else {
            this.iRv.setVisibility(8);
        }
        cCA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.iVy != null) {
            bVar.iVy.aN(true);
            bVar.iVy.setEnabled(false);
        }
    }

    private String zB(int i) {
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
    public void Qj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.Bo(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.iVq != null) {
                    a.this.iVq.clear();
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
        aVar.b(this.mTbPageContext).bpc();
    }

    private void cCA() {
        ap.setBackgroundColor(this.iVl, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iVj, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iVo, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ap.setImageResource(this.iVm, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.iVn, R.color.cp_cont_e, 1);
        for (b bVar : this.iVp) {
            ap.setBackgroundResource(bVar.fTz, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.iVw, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.iVx, R.color.cp_link_tip_d, 1);
            bVar.iVy.aN(!bVar.iVy.isEnabled());
        }
    }

    public void hide() {
        this.iVl.setVisibility(8);
    }

    public void show() {
        this.iVl.setVisibility(0);
    }
}
