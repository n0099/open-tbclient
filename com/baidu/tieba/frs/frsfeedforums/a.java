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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes21.dex */
public class a {
    private LikeModel eYI;
    private boolean iSd;
    private View iSi;
    private View iVV;
    private LinearLayout iVX;
    private ImageView iVY;
    private TextView iVZ;
    private View iWa;
    private List<FeedForumData> iWc;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> iWb = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean iWd = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bh.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.eYI.gp(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ar(str2).dR("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.PA();
                TiebaStatic.log(new ar("c10029").dR("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.iVZ.getId() && y.getCount(a.this.iWc) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.iWc)));
                    TiebaStatic.log(new ar("c10046").dR("fid", a.this.mForumId));
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
                    TiebaStatic.log(new ar(str).dR("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d ikM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(a.this.eYI.getErrorCode(), a.this.eYI.getErrorString())) {
                AntiHelper.bj(a.this.mTbPageContext.getPageActivity(), a.this.eYI.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.eYI.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.eYI.getErrorString());
                }
            } else {
                final v vVar = (v) obj;
                if (y.getCount(a.this.iWc) > 0 && vVar != null) {
                    Iterator it = a.this.iWb.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.iWk.getTag();
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
                                Iterator it2 = a.this.iWc.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(vVar.getFid())) {
                                        a.this.iWc.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.iWc.size() > 0) {
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
        this.iVX = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.iVV = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.iWa = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.iVX.findViewById(R.id.like_feed_forums_label);
        this.iVY = (ImageView) this.iVX.findViewById(R.id.like_feed_forums_arrow);
        this.iVY.setOnClickListener(this.mOnClickListener);
        this.iVZ = (TextView) this.iVX.findViewById(R.id.feed_forums_more);
        this.iSi = view.findViewById(R.id.feed_forum_bottom_line);
        this.iVZ.setOnClickListener(this.mOnClickListener);
        this.eYI = new LikeModel(tbPageContext);
        this.eYI.setUniqueId(bdUniqueId);
        this.eYI.setLoadDataCallBack(this.ikM);
        this.mType = i;
        this.iSd = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.iWc = list;
        refreshUI();
        if (this.mType == 2 && !this.iWd) {
            TiebaStatic.log(new ar("c10035").dR("fid", this.mForumId));
            this.iWd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.iWc) == 0) {
            hide();
            return;
        }
        show();
        int size = this.iWc.size() > 2 ? 2 : this.iWc.size();
        int size2 = size - this.iWb.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.iVX.addView(inflate);
                this.iWb.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.iWb.size() - 1;
                this.iVX.removeView(this.iWb.get(size3).fTg);
                this.iWb.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.iWc.get(i4);
            b bVar = this.iWb.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.fTg.setTag(feedForumData);
                bVar.fTg.setOnClickListener(this.mOnClickListener);
                bVar.iWh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.iWh.setPlaceHolder(1);
                bVar.iWh.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.iWi.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), zZ(feedForumData.getMemberCount()), zZ(feedForumData.getPostNum())));
                bVar.iWj.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.iWk.setClickable(true);
                    bVar.iWk.setOnClickListener(this.mOnClickListener);
                    bVar.iWk.setTag(feedForumData);
                    bVar.iWk.aP(false);
                    bVar.iWk.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.iSd) {
            this.iSi.setVisibility(0);
        } else {
            this.iSi.setVisibility(8);
        }
        cCe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.iWk != null) {
            bVar.iWk.aP(true);
            bVar.iWk.setEnabled(false);
        }
    }

    private String zZ(int i) {
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
    public void PA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.AJ(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.iWc != null) {
                    a.this.iWc.clear();
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
        aVar.b(this.mTbPageContext).bog();
    }

    private void cCe() {
        ap.setBackgroundColor(this.iVX, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iVV, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iWa, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTvLable, R.color.CAM_X0108, 1);
        ap.setImageResource(this.iVY, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.iVZ, R.color.CAM_X0110, 1);
        for (b bVar : this.iWb) {
            ap.setBackgroundResource(bVar.fTg, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(bVar.iWi, R.color.CAM_X0108, 1);
            ap.setViewTextColor(bVar.iWj, R.color.CAM_X0305, 1);
            bVar.iWk.aP(!bVar.iWk.isEnabled());
        }
    }

    public void hide() {
        this.iVX.setVisibility(8);
    }

    public void show() {
        this.iVX.setVisibility(0);
    }
}
