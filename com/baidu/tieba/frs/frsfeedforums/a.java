package com.baidu.tieba.frs.frsfeedforums;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
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
import com.baidu.tieba.tbadkCore.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private LikeModel foW;
    private boolean jss;
    private View jsx;
    private View jwq;
    private LinearLayout jyU;
    private ImageView jyV;
    private TextView jyW;
    private View jyX;
    private List<FeedForumData> jyZ;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> jyY = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean jza = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bh.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.foW.gy(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ar(str2).dR("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.QH();
                TiebaStatic.log(new ar("c10029").dR("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.jyW.getId() && y.getCount(a.this.jyZ) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.jyZ)));
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
    private e iKU = new e() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bX(a.this.foW.getErrorCode(), a.this.foW.getErrorString())) {
                AntiHelper.bq(a.this.mTbPageContext.getPageActivity(), a.this.foW.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.foW.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.foW.getErrorString());
                }
            } else {
                final w wVar = (w) obj;
                if (y.getCount(a.this.jyZ) > 0 && wVar != null) {
                    Iterator it = a.this.jyY.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.jzh.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.getFid())) {
                            feedForumData.setIsLike(1);
                            a.this.a(bVar);
                            break;
                        }
                    }
                    if (a.this.mType == 1) {
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it2 = a.this.jyZ.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(wVar.getFid())) {
                                        a.this.jyZ.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.jyZ.size() > 0) {
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
        this.jyU = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.jwq = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.jyX = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.jyU.findViewById(R.id.like_feed_forums_label);
        this.jyV = (ImageView) this.jyU.findViewById(R.id.like_feed_forums_arrow);
        this.jyV.setOnClickListener(this.mOnClickListener);
        this.jyW = (TextView) this.jyU.findViewById(R.id.feed_forums_more);
        this.jsx = view.findViewById(R.id.feed_forum_bottom_line);
        this.jyW.setOnClickListener(this.mOnClickListener);
        this.foW = new LikeModel(tbPageContext);
        this.foW.setUniqueId(bdUniqueId);
        this.foW.setLoadDataCallBack(this.iKU);
        this.mType = i;
        this.jss = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.jyZ = list;
        refreshUI();
        if (this.mType == 2 && !this.jza) {
            TiebaStatic.log(new ar("c10035").dR("fid", this.mForumId));
            this.jza = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.jyZ) == 0) {
            hide();
            return;
        }
        show();
        int size = this.jyZ.size() > 2 ? 2 : this.jyZ.size();
        int size2 = size - this.jyY.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.jyU.addView(inflate);
                this.jyY.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.jyY.size() - 1;
                this.jyU.removeView(this.jyY.get(size3).gki);
                this.jyY.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.jyZ.get(i4);
            b bVar = this.jyY.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.gki.setTag(feedForumData);
                bVar.gki.setOnClickListener(this.mOnClickListener);
                bVar.jze.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.jze.setPlaceHolder(1);
                bVar.jze.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.jzf.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), zE(feedForumData.getMemberCount()), zE(feedForumData.getPostNum())));
                bVar.jzg.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.jzh.setClickable(true);
                    bVar.jzh.setOnClickListener(this.mOnClickListener);
                    bVar.jzh.setTag(feedForumData);
                    bVar.jzh.aM(false);
                    bVar.jzh.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.jss) {
            this.jsx.setVisibility(0);
        } else {
            this.jsx.setVisibility(8);
        }
        cHZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.jzh != null) {
            bVar.jzh.aM(true);
            bVar.jzh.setEnabled(false);
        }
    }

    private String zE(int i) {
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
    public void QH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.AB(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.jyZ != null) {
                    a.this.jyZ.clear();
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
        aVar.b(this.mTbPageContext).bqz();
    }

    private void cHZ() {
        ap.setBackgroundColor(this.jyU, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jwq, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jyX, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTvLable, R.color.CAM_X0108, 1);
        ap.setImageResource(this.jyV, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.jyW, R.color.CAM_X0110, 1);
        for (b bVar : this.jyY) {
            ap.setBackgroundResource(bVar.gki, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(bVar.jzf, R.color.CAM_X0108, 1);
            ap.setViewTextColor(bVar.jzg, R.color.CAM_X0305, 1);
            bVar.jzh.aM(!bVar.jzh.isEnabled());
        }
    }

    public void hide() {
        this.jyU.setVisibility(8);
    }

    public void show() {
        this.jyU.setVisibility(0);
    }
}
