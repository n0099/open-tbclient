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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private LikeModel crO;
    private boolean fCQ;
    private View fCV;
    private View fFF;
    private LinearLayout fFH;
    private ImageView fFI;
    private TextView fFJ;
    private View fFK;
    private List<FeedForumData> fFM;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> fFL = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean fFN = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bc.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.crO.dY(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).bS("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").bS("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.fFJ.getId() && v.getCount(a.this.fFM) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.fFM)));
                    TiebaStatic.log(new an("c10046").bS("fid", a.this.mForumId));
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
                    TiebaStatic.log(new an(str).bS("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d fbd = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.aG(a.this.crO.getErrorCode(), a.this.crO.getErrorString())) {
                AntiHelper.aS(a.this.mTbPageContext.getPageActivity(), a.this.crO.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.crO.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.crO.getErrorString());
                }
            } else {
                final t tVar = (t) obj;
                if (v.getCount(a.this.fFM) > 0 && tVar != null) {
                    Iterator it = a.this.fFL.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.fFU.getTag();
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
                                Iterator it2 = a.this.fFM.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(tVar.getFid())) {
                                        a.this.fFM.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.fFM.size() > 0) {
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
        this.fFH = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.fFF = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.fFK = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.fFH.findViewById(R.id.like_feed_forums_label);
        this.fFI = (ImageView) this.fFH.findViewById(R.id.like_feed_forums_arrow);
        this.fFI.setOnClickListener(this.mOnClickListener);
        this.fFJ = (TextView) this.fFH.findViewById(R.id.feed_forums_more);
        this.fCV = view.findViewById(R.id.feed_forum_bottom_line);
        this.fFJ.setOnClickListener(this.mOnClickListener);
        this.crO = new LikeModel(tbPageContext);
        this.crO.setUniqueId(bdUniqueId);
        this.crO.setLoadDataCallBack(this.fbd);
        this.mType = i;
        this.fCQ = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.fFM = list;
        refreshUI();
        if (this.mType == 2 && !this.fFN) {
            TiebaStatic.log(new an("c10035").bS("fid", this.mForumId));
            this.fFN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.getCount(this.fFM) == 0) {
            hide();
            return;
        }
        show();
        int size = this.fFM.size() > 2 ? 2 : this.fFM.size();
        int size2 = size - this.fFL.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.fFH.addView(inflate);
                this.fFL.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.fFL.size() - 1;
                this.fFH.removeView(this.fFL.get(size3).diF);
                this.fFL.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.fFM.get(i4);
            b bVar = this.fFL.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.diF.setTag(feedForumData);
                bVar.diF.setOnClickListener(this.mOnClickListener);
                bVar.fFR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.fFR.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.fFS.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), qY(feedForumData.getMemberCount()), qY(feedForumData.getPostNum())));
                bVar.fFT.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.fFU.setClickable(true);
                    bVar.fFU.setOnClickListener(this.mOnClickListener);
                    bVar.fFU.setTag(feedForumData);
                    bVar.fFU.ew(false);
                    bVar.fFU.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.fCQ) {
            this.fCV.setVisibility(0);
        } else {
            this.fCV.setVisibility(8);
        }
        bnw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.fFU != null) {
            bVar.fFU.ew(true);
            bVar.fFU.setEnabled(false);
        }
    }

    private String qY(int i) {
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
        aVar.nn(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.fFM != null) {
                    a.this.fFM.clear();
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
        aVar.b(this.mTbPageContext).akM();
    }

    private void bnw() {
        am.setBackgroundColor(this.fFH, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fFF, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fFK, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        am.setImageResource(this.fFI, R.drawable.icon_frs_recommend_arrow_down);
        am.setViewTextColor(this.fFJ, R.color.cp_cont_e, 1);
        for (b bVar : this.fFL) {
            am.setBackgroundResource(bVar.diF, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.fFS, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.fFT, R.color.cp_link_tip_d, 1);
            bVar.fFU.ew(!bVar.fFU.isEnabled());
        }
    }

    public void hide() {
        this.fFH.setVisibility(8);
    }

    public void show() {
        this.fFH.setVisibility(0);
    }
}
