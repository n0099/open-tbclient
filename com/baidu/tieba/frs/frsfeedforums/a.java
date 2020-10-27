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
    private LikeModel eTL;
    private boolean iLt;
    private View iLy;
    private View iPm;
    private LinearLayout iPo;
    private ImageView iPp;
    private TextView iPq;
    private View iPr;
    private List<FeedForumData> iPt;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> iPs = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean iPu = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bg.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.eTL.gp(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new aq(str2).dR("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.PJ();
                TiebaStatic.log(new aq("c10029").dR("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.iPq.getId() && y.getCount(a.this.iPt) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.iPt)));
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
    private com.baidu.adp.base.d ieb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bN(a.this.eTL.getErrorCode(), a.this.eTL.getErrorString())) {
                AntiHelper.bm(a.this.mTbPageContext.getPageActivity(), a.this.eTL.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.eTL.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.eTL.getErrorString());
                }
            } else {
                final v vVar = (v) obj;
                if (y.getCount(a.this.iPt) > 0 && vVar != null) {
                    Iterator it = a.this.iPs.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.iPB.getTag();
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
                                Iterator it2 = a.this.iPt.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(vVar.getFid())) {
                                        a.this.iPt.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.iPt.size() > 0) {
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
        this.iPo = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.iPm = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.iPr = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.iPo.findViewById(R.id.like_feed_forums_label);
        this.iPp = (ImageView) this.iPo.findViewById(R.id.like_feed_forums_arrow);
        this.iPp.setOnClickListener(this.mOnClickListener);
        this.iPq = (TextView) this.iPo.findViewById(R.id.feed_forums_more);
        this.iLy = view.findViewById(R.id.feed_forum_bottom_line);
        this.iPq.setOnClickListener(this.mOnClickListener);
        this.eTL = new LikeModel(tbPageContext);
        this.eTL.setUniqueId(bdUniqueId);
        this.eTL.setLoadDataCallBack(this.ieb);
        this.mType = i;
        this.iLt = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.iPt = list;
        refreshUI();
        if (this.mType == 2 && !this.iPu) {
            TiebaStatic.log(new aq("c10035").dR("fid", this.mForumId));
            this.iPu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.iPt) == 0) {
            hide();
            return;
        }
        show();
        int size = this.iPt.size() > 2 ? 2 : this.iPt.size();
        int size2 = size - this.iPs.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.iPo.addView(inflate);
                this.iPs.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.iPs.size() - 1;
                this.iPo.removeView(this.iPs.get(size3).fNJ);
                this.iPs.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.iPt.get(i4);
            b bVar = this.iPs.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.fNJ.setTag(feedForumData);
                bVar.fNJ.setOnClickListener(this.mOnClickListener);
                bVar.iPy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.iPy.setPlaceHolder(1);
                bVar.iPy.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.iPz.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), zo(feedForumData.getMemberCount()), zo(feedForumData.getPostNum())));
                bVar.iPA.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.iPB.setClickable(true);
                    bVar.iPB.setOnClickListener(this.mOnClickListener);
                    bVar.iPB.setTag(feedForumData);
                    bVar.iPB.aN(false);
                    bVar.iPB.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.iLt) {
            this.iLy.setVisibility(0);
        } else {
            this.iLy.setVisibility(8);
        }
        czZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.iPB != null) {
            bVar.iPB.aN(true);
            bVar.iPB.setEnabled(false);
        }
    }

    private String zo(int i) {
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
    public void PJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.Ba(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.iPt != null) {
                    a.this.iPt.clear();
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
        aVar.b(this.mTbPageContext).bmC();
    }

    private void czZ() {
        ap.setBackgroundColor(this.iPo, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iPm, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iPr, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ap.setImageResource(this.iPp, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.iPq, R.color.cp_cont_e, 1);
        for (b bVar : this.iPs) {
            ap.setBackgroundResource(bVar.fNJ, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.iPz, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.iPA, R.color.cp_link_tip_d, 1);
            bVar.iPB.aN(!bVar.iPB.isEnabled());
        }
    }

    public void hide() {
        this.iPo.setVisibility(8);
    }

    public void show() {
        this.iPo.setVisibility(0);
    }
}
