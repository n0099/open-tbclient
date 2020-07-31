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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private LikeModel emT;
    private boolean hOJ;
    private View hOO;
    private View hSF;
    private LinearLayout hSH;
    private ImageView hSI;
    private TextView hSJ;
    private View hSK;
    private List<FeedForumData> hSM;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> hSL = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean hSN = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bf.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.emT.fz(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ap(str2).dn("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new ap("c10029").dn("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.hSJ.getId() && x.getCount(a.this.hSM) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.hSM)));
                    TiebaStatic.log(new ap("c10046").dn("fid", a.this.mForumId));
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
                    TiebaStatic.log(new ap(str).dn("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hiv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bB(a.this.emT.getErrorCode(), a.this.emT.getErrorString())) {
                AntiHelper.aW(a.this.mTbPageContext.getPageActivity(), a.this.emT.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.emT.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.emT.getErrorString());
                }
            } else {
                final u uVar = (u) obj;
                if (x.getCount(a.this.hSM) > 0 && uVar != null) {
                    Iterator it = a.this.hSL.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.hSU.getTag();
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
                                Iterator it2 = a.this.hSM.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(uVar.getFid())) {
                                        a.this.hSM.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.hSM.size() > 0) {
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
        this.hSH = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.hSF = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.hSK = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.hSH.findViewById(R.id.like_feed_forums_label);
        this.hSI = (ImageView) this.hSH.findViewById(R.id.like_feed_forums_arrow);
        this.hSI.setOnClickListener(this.mOnClickListener);
        this.hSJ = (TextView) this.hSH.findViewById(R.id.feed_forums_more);
        this.hOO = view.findViewById(R.id.feed_forum_bottom_line);
        this.hSJ.setOnClickListener(this.mOnClickListener);
        this.emT = new LikeModel(tbPageContext);
        this.emT.setUniqueId(bdUniqueId);
        this.emT.setLoadDataCallBack(this.hiv);
        this.mType = i;
        this.hOJ = z;
    }

    public void g(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.hSM = list;
        refreshUI();
        if (this.mType == 2 && !this.hSN) {
            TiebaStatic.log(new ap("c10035").dn("fid", this.mForumId));
            this.hSN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (x.getCount(this.hSM) == 0) {
            hide();
            return;
        }
        show();
        int size = this.hSM.size() > 2 ? 2 : this.hSM.size();
        int size2 = size - this.hSL.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.hSH.addView(inflate);
                this.hSL.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.hSL.size() - 1;
                this.hSH.removeView(this.hSL.get(size3).feu);
                this.hSL.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.hSM.get(i4);
            b bVar = this.hSL.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.feu.setTag(feedForumData);
                bVar.feu.setOnClickListener(this.mOnClickListener);
                bVar.hSR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.hSR.setPlaceHolder(1);
                bVar.hSR.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.hSS.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), vx(feedForumData.getMemberCount()), vx(feedForumData.getPostNum())));
                bVar.hST.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.hSU.setClickable(true);
                    bVar.hSU.setOnClickListener(this.mOnClickListener);
                    bVar.hSU.setTag(feedForumData);
                    bVar.hSU.aM(false);
                    bVar.hSU.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.hOJ) {
            this.hOO.setVisibility(0);
        } else {
            this.hOO.setVisibility(8);
        }
        cfC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.hSU != null) {
            bVar.hSU.aM(true);
            bVar.hSU.setEnabled(false);
        }
    }

    private String vx(int i) {
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
        aVar.xl(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.hSM != null) {
                    a.this.hSM.clear();
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
        aVar.b(this.mTbPageContext).aYL();
    }

    private void cfC() {
        ao.setBackgroundColor(this.hSH, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hSF, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.hSK, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ao.setImageResource(this.hSI, R.drawable.icon_frs_recommend_arrow_down);
        ao.setViewTextColor(this.hSJ, R.color.cp_cont_e, 1);
        for (b bVar : this.hSL) {
            ao.setBackgroundResource(bVar.feu, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ao.setViewTextColor(bVar.hSS, R.color.cp_cont_c, 1);
            ao.setViewTextColor(bVar.hST, R.color.cp_link_tip_d, 1);
            bVar.hSU.aM(!bVar.hSU.isEnabled());
        }
    }

    public void hide() {
        this.hSH.setVisibility(8);
    }

    public void show() {
        this.hSH.setVisibility(0);
    }
}
