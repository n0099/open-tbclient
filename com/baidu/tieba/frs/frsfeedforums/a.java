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
    private LikeModel ewX;
    private boolean icQ;
    private View icV;
    private View igP;
    private LinearLayout igR;
    private ImageView igS;
    private TextView igT;
    private View igU;
    private List<FeedForumData> igW;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> igV = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean igX = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bg.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.ewX.fQ(feedForumData.getForumName(), feedForumData.getForumId());
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
                if (view.getId() == a.this.igT.getId() && y.getCount(a.this.igW) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.igW)));
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
    private com.baidu.adp.base.d hvu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bz(a.this.ewX.getErrorCode(), a.this.ewX.getErrorString())) {
                AntiHelper.bb(a.this.mTbPageContext.getPageActivity(), a.this.ewX.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.ewX.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.ewX.getErrorString());
                }
            } else {
                final v vVar = (v) obj;
                if (y.getCount(a.this.igW) > 0 && vVar != null) {
                    Iterator it = a.this.igV.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.ihe.getTag();
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
                                Iterator it2 = a.this.igW.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(vVar.getFid())) {
                                        a.this.igW.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.igW.size() > 0) {
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
        this.igR = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.igP = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.igU = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.igR.findViewById(R.id.like_feed_forums_label);
        this.igS = (ImageView) this.igR.findViewById(R.id.like_feed_forums_arrow);
        this.igS.setOnClickListener(this.mOnClickListener);
        this.igT = (TextView) this.igR.findViewById(R.id.feed_forums_more);
        this.icV = view.findViewById(R.id.feed_forum_bottom_line);
        this.igT.setOnClickListener(this.mOnClickListener);
        this.ewX = new LikeModel(tbPageContext);
        this.ewX.setUniqueId(bdUniqueId);
        this.ewX.setLoadDataCallBack(this.hvu);
        this.mType = i;
        this.icQ = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.igW = list;
        refreshUI();
        if (this.mType == 2 && !this.igX) {
            TiebaStatic.log(new aq("c10035").dD("fid", this.mForumId));
            this.igX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.igW) == 0) {
            hide();
            return;
        }
        show();
        int size = this.igW.size() > 2 ? 2 : this.igW.size();
        int size2 = size - this.igV.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.igR.addView(inflate);
                this.igV.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.igV.size() - 1;
                this.igR.removeView(this.igV.get(size3).fpN);
                this.igV.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.igW.get(i4);
            b bVar = this.igV.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.fpN.setTag(feedForumData);
                bVar.fpN.setOnClickListener(this.mOnClickListener);
                bVar.ihb.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.ihb.setPlaceHolder(1);
                bVar.ihb.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.ihc.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), xQ(feedForumData.getMemberCount()), xQ(feedForumData.getPostNum())));
                bVar.ihd.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.ihe.setClickable(true);
                    bVar.ihe.setOnClickListener(this.mOnClickListener);
                    bVar.ihe.setTag(feedForumData);
                    bVar.ihe.aN(false);
                    bVar.ihe.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.icQ) {
            this.icV.setVisibility(0);
        } else {
            this.icV.setVisibility(8);
        }
        cqh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.ihe != null) {
            bVar.ihe.aN(true);
            bVar.ihe.setEnabled(false);
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
        aVar.zz(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.igW != null) {
                    a.this.igW.clear();
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

    private void cqh() {
        ap.setBackgroundColor(this.igR, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.igP, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.igU, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ap.setImageResource(this.igS, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.igT, R.color.cp_cont_e, 1);
        for (b bVar : this.igV) {
            ap.setBackgroundResource(bVar.fpN, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.ihc, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.ihd, R.color.cp_link_tip_d, 1);
            bVar.ihe.aN(!bVar.ihe.isEnabled());
        }
    }

    public void hide() {
        this.igR.setVisibility(8);
    }

    public void show() {
        this.igR.setVisibility(0);
    }
}
