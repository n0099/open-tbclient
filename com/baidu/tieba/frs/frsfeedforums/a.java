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
    private boolean hOL;
    private View hOQ;
    private View hSH;
    private LinearLayout hSJ;
    private ImageView hSK;
    private TextView hSL;
    private View hSM;
    private List<FeedForumData> hSO;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> hSN = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean hSP = false;
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
                if (view.getId() == a.this.hSL.getId() && x.getCount(a.this.hSO) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.hSO)));
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
                if (x.getCount(a.this.hSO) > 0 && uVar != null) {
                    Iterator it = a.this.hSN.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.hSW.getTag();
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
                                Iterator it2 = a.this.hSO.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(uVar.getFid())) {
                                        a.this.hSO.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.hSO.size() > 0) {
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
        this.hSJ = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.hSH = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.hSM = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.hSJ.findViewById(R.id.like_feed_forums_label);
        this.hSK = (ImageView) this.hSJ.findViewById(R.id.like_feed_forums_arrow);
        this.hSK.setOnClickListener(this.mOnClickListener);
        this.hSL = (TextView) this.hSJ.findViewById(R.id.feed_forums_more);
        this.hOQ = view.findViewById(R.id.feed_forum_bottom_line);
        this.hSL.setOnClickListener(this.mOnClickListener);
        this.emT = new LikeModel(tbPageContext);
        this.emT.setUniqueId(bdUniqueId);
        this.emT.setLoadDataCallBack(this.hiv);
        this.mType = i;
        this.hOL = z;
    }

    public void g(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.hSO = list;
        refreshUI();
        if (this.mType == 2 && !this.hSP) {
            TiebaStatic.log(new ap("c10035").dn("fid", this.mForumId));
            this.hSP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (x.getCount(this.hSO) == 0) {
            hide();
            return;
        }
        show();
        int size = this.hSO.size() > 2 ? 2 : this.hSO.size();
        int size2 = size - this.hSN.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.hSJ.addView(inflate);
                this.hSN.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.hSN.size() - 1;
                this.hSJ.removeView(this.hSN.get(size3).feu);
                this.hSN.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.hSO.get(i4);
            b bVar = this.hSN.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.feu.setTag(feedForumData);
                bVar.feu.setOnClickListener(this.mOnClickListener);
                bVar.hST.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.hST.setPlaceHolder(1);
                bVar.hST.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.hSU.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), vx(feedForumData.getMemberCount()), vx(feedForumData.getPostNum())));
                bVar.hSV.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.hSW.setClickable(true);
                    bVar.hSW.setOnClickListener(this.mOnClickListener);
                    bVar.hSW.setTag(feedForumData);
                    bVar.hSW.aM(false);
                    bVar.hSW.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.hOL) {
            this.hOQ.setVisibility(0);
        } else {
            this.hOQ.setVisibility(8);
        }
        cfC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.hSW != null) {
            bVar.hSW.aM(true);
            bVar.hSW.setEnabled(false);
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
                if (a.this.hSO != null) {
                    a.this.hSO.clear();
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
        ao.setBackgroundColor(this.hSJ, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hSH, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.hSM, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        ao.setImageResource(this.hSK, R.drawable.icon_frs_recommend_arrow_down);
        ao.setViewTextColor(this.hSL, R.color.cp_cont_e, 1);
        for (b bVar : this.hSN) {
            ao.setBackgroundResource(bVar.feu, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ao.setViewTextColor(bVar.hSU, R.color.cp_cont_c, 1);
            ao.setViewTextColor(bVar.hSV, R.color.cp_link_tip_d, 1);
            bVar.hSW.aM(!bVar.hSW.isEnabled());
        }
    }

    public void hide() {
        this.hSJ.setVisibility(8);
    }

    public void show() {
        this.hSJ.setVisibility(0);
    }
}
