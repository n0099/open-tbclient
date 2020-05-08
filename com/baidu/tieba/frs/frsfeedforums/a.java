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
    private LikeModel dKs;
    private boolean hgR;
    private View hgW;
    private View hjX;
    private LinearLayout hjZ;
    private ImageView hka;
    private TextView hkb;
    private View hkc;
    private List<FeedForumData> hke;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> hkd = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean hkf = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bc.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.dKs.eP(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new an(str2).cI("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.showDialog();
                TiebaStatic.log(new an("c10029").cI("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.hkb.getId() && v.getCount(a.this.hke) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.hke)));
                    TiebaStatic.log(new an("c10046").cI("fid", a.this.mForumId));
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
                    TiebaStatic.log(new an(str).cI("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d gBi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bq(a.this.dKs.getErrorCode(), a.this.dKs.getErrorString())) {
                AntiHelper.aW(a.this.mTbPageContext.getPageActivity(), a.this.dKs.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.dKs.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.dKs.getErrorString());
                }
            } else {
                final u uVar = (u) obj;
                if (v.getCount(a.this.hke) > 0 && uVar != null) {
                    Iterator it = a.this.hkd.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.hkm.getTag();
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
                                Iterator it2 = a.this.hke.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(uVar.getFid())) {
                                        a.this.hke.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.hke.size() > 0) {
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
        this.hjZ = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.hjX = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.hkc = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.hjZ.findViewById(R.id.like_feed_forums_label);
        this.hka = (ImageView) this.hjZ.findViewById(R.id.like_feed_forums_arrow);
        this.hka.setOnClickListener(this.mOnClickListener);
        this.hkb = (TextView) this.hjZ.findViewById(R.id.feed_forums_more);
        this.hgW = view.findViewById(R.id.feed_forum_bottom_line);
        this.hkb.setOnClickListener(this.mOnClickListener);
        this.dKs = new LikeModel(tbPageContext);
        this.dKs.setUniqueId(bdUniqueId);
        this.dKs.setLoadDataCallBack(this.gBi);
        this.mType = i;
        this.hgR = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.hke = list;
        refreshUI();
        if (this.mType == 2 && !this.hkf) {
            TiebaStatic.log(new an("c10035").cI("fid", this.mForumId));
            this.hkf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (v.getCount(this.hke) == 0) {
            hide();
            return;
        }
        show();
        int size = this.hke.size() > 2 ? 2 : this.hke.size();
        int size2 = size - this.hkd.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.hjZ.addView(inflate);
                this.hkd.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.hkd.size() - 1;
                this.hjZ.removeView(this.hkd.get(size3).eAX);
                this.hkd.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.hke.get(i4);
            b bVar = this.hkd.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.eAX.setTag(feedForumData);
                bVar.eAX.setOnClickListener(this.mOnClickListener);
                bVar.hkj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.hkj.setPlaceHolder(1);
                bVar.hkj.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.hkk.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), tT(feedForumData.getMemberCount()), tT(feedForumData.getPostNum())));
                bVar.hkl.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.hkm.setClickable(true);
                    bVar.hkm.setOnClickListener(this.mOnClickListener);
                    bVar.hkm.setTag(feedForumData);
                    bVar.hkm.gT(false);
                    bVar.hkm.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.hgR) {
            this.hgW.setVisibility(0);
        } else {
            this.hgW.setVisibility(8);
        }
        bSj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.hkm != null) {
            bVar.hkm.gT(true);
            bVar.hkm.setEnabled(false);
        }
    }

    private String tT(int i) {
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
        aVar.ui(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.hke != null) {
                    a.this.hke.clear();
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
        aVar.b(this.mTbPageContext).aMS();
    }

    private void bSj() {
        am.setBackgroundColor(this.hjZ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hjX, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hkc, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTvLable, R.color.cp_cont_c, 1);
        am.setImageResource(this.hka, R.drawable.icon_frs_recommend_arrow_down);
        am.setViewTextColor(this.hkb, R.color.cp_cont_e, 1);
        for (b bVar : this.hkd) {
            am.setBackgroundResource(bVar.eAX, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.hkk, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.hkl, R.color.cp_link_tip_d, 1);
            bVar.hkm.gT(!bVar.hkm.isEnabled());
        }
    }

    public void hide() {
        this.hjZ.setVisibility(8);
    }

    public void show() {
        this.hjZ.setVisibility(0);
    }
}
