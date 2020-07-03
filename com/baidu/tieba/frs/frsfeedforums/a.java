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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    private LikeModel egK;
    private boolean hIJ;
    private View hIO;
    private View hMG;
    private LinearLayout hMI;
    private ImageView hMJ;
    private TextView hMK;
    private View hML;
    private List<FeedForumData> hMN;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> hMM = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean hMO = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (be.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.egK.fx(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ao(str2).dk("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new ao("c10029").dk("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.hMK.getId() && w.getCount(a.this.hMN) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.hMN)));
                    TiebaStatic.log(new ao("c10046").dk("fid", a.this.mForumId));
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
                    TiebaStatic.log(new ao(str).dk("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hcL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bA(a.this.egK.getErrorCode(), a.this.egK.getErrorString())) {
                AntiHelper.aX(a.this.mTbPageContext.getPageActivity(), a.this.egK.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.egK.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.egK.getErrorString());
                }
            } else {
                final u uVar = (u) obj;
                if (w.getCount(a.this.hMN) > 0 && uVar != null) {
                    Iterator it = a.this.hMM.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.hMV.getTag();
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
                                Iterator it2 = a.this.hMN.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(uVar.getFid())) {
                                        a.this.hMN.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.hMN.size() > 0) {
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
        this.hMI = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.hMG = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.hML = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.hMI.findViewById(R.id.like_feed_forums_label);
        this.hMJ = (ImageView) this.hMI.findViewById(R.id.like_feed_forums_arrow);
        this.hMJ.setOnClickListener(this.mOnClickListener);
        this.hMK = (TextView) this.hMI.findViewById(R.id.feed_forums_more);
        this.hIO = view.findViewById(R.id.feed_forum_bottom_line);
        this.hMK.setOnClickListener(this.mOnClickListener);
        this.egK = new LikeModel(tbPageContext);
        this.egK.setUniqueId(bdUniqueId);
        this.egK.setLoadDataCallBack(this.hcL);
        this.mType = i;
        this.hIJ = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.hMN = list;
        refreshUI();
        if (this.mType == 2 && !this.hMO) {
            TiebaStatic.log(new ao("c10035").dk("fid", this.mForumId));
            this.hMO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (w.getCount(this.hMN) == 0) {
            hide();
            return;
        }
        show();
        int size = this.hMN.size() > 2 ? 2 : this.hMN.size();
        int size2 = size - this.hMM.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.hMI.addView(inflate);
                this.hMM.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.hMM.size() - 1;
                this.hMI.removeView(this.hMM.get(size3).eZS);
                this.hMM.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.hMN.get(i4);
            b bVar = this.hMM.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.eZS.setTag(feedForumData);
                bVar.eZS.setOnClickListener(this.mOnClickListener);
                bVar.hMS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.hMS.setPlaceHolder(1);
                bVar.hMS.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.hMT.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), vf(feedForumData.getMemberCount()), vf(feedForumData.getPostNum())));
                bVar.hMU.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.hMV.setClickable(true);
                    bVar.hMV.setOnClickListener(this.mOnClickListener);
                    bVar.hMV.setTag(feedForumData);
                    bVar.hMV.hA(false);
                    bVar.hMV.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.hIJ) {
            this.hIO.setVisibility(0);
        } else {
            this.hIO.setVisibility(8);
        }
        ccd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.hMV != null) {
            bVar.hMV.hA(true);
            bVar.hMV.setEnabled(false);
        }
    }

    private String vf(int i) {
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
        aVar.we(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.hMN != null) {
                    a.this.hMN.clear();
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
        aVar.b(this.mTbPageContext).aUN();
    }

    private void ccd() {
        an.setBackgroundColor(this.hMI, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.hMG, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.hML, R.color.cp_bg_line_d);
        an.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        an.setImageResource(this.hMJ, R.drawable.icon_frs_recommend_arrow_down);
        an.setViewTextColor(this.hMK, R.color.cp_cont_e, 1);
        for (b bVar : this.hMM) {
            an.setBackgroundResource(bVar.eZS, R.drawable.frs_like_feed_forum_item_bg);
            an.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            an.setViewTextColor(bVar.hMT, R.color.cp_cont_c, 1);
            an.setViewTextColor(bVar.hMU, R.color.cp_link_tip_d, 1);
            bVar.hMV.hA(!bVar.hMV.isEnabled());
        }
    }

    public void hide() {
        this.hMI.setVisibility(8);
    }

    public void show() {
        this.hMI.setVisibility(0);
    }
}
