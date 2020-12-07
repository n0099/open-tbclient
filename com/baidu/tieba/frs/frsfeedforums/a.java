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
import com.baidu.tieba.tbadkCore.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private LikeModel fgf;
    private boolean jcX;
    private View jdc;
    private View jgR;
    private List<FeedForumData> jjB;
    private LinearLayout jjw;
    private ImageView jjx;
    private TextView jjy;
    private View jjz;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> jjA = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean jjC = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bh.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.fgf.gu(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new ar(str2).dY("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.RU();
                TiebaStatic.log(new ar("c10029").dY("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.jjy.getId() && y.getCount(a.this.jjB) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.jjB)));
                    TiebaStatic.log(new ar("c10046").dY("fid", a.this.mForumId));
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
                    TiebaStatic.log(new ar(str).dY("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d ivF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(a.this.fgf.getErrorCode(), a.this.fgf.getErrorString())) {
                AntiHelper.bn(a.this.mTbPageContext.getPageActivity(), a.this.fgf.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.fgf.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.fgf.getErrorString());
                }
            } else {
                final w wVar = (w) obj;
                if (y.getCount(a.this.jjB) > 0 && wVar != null) {
                    Iterator it = a.this.jjA.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.jjJ.getTag();
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
                                Iterator it2 = a.this.jjB.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(wVar.getFid())) {
                                        a.this.jjB.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.jjB.size() > 0) {
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
        this.jjw = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.jgR = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.jjz = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.jjw.findViewById(R.id.like_feed_forums_label);
        this.jjx = (ImageView) this.jjw.findViewById(R.id.like_feed_forums_arrow);
        this.jjx.setOnClickListener(this.mOnClickListener);
        this.jjy = (TextView) this.jjw.findViewById(R.id.feed_forums_more);
        this.jdc = view.findViewById(R.id.feed_forum_bottom_line);
        this.jjy.setOnClickListener(this.mOnClickListener);
        this.fgf = new LikeModel(tbPageContext);
        this.fgf.setUniqueId(bdUniqueId);
        this.fgf.setLoadDataCallBack(this.ivF);
        this.mType = i;
        this.jcX = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.jjB = list;
        refreshUI();
        if (this.mType == 2 && !this.jjC) {
            TiebaStatic.log(new ar("c10035").dY("fid", this.mForumId));
            this.jjC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (y.getCount(this.jjB) == 0) {
            hide();
            return;
        }
        show();
        int size = this.jjB.size() > 2 ? 2 : this.jjB.size();
        int size2 = size - this.jjA.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.jjw.addView(inflate);
                this.jjA.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.jjA.size() - 1;
                this.jjw.removeView(this.jjA.get(size3).gbq);
                this.jjA.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.jjB.get(i4);
            b bVar = this.jjA.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.gbq.setTag(feedForumData);
                bVar.gbq.setOnClickListener(this.mOnClickListener);
                bVar.jjG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.jjG.setPlaceHolder(1);
                bVar.jjG.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.jjH.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), AN(feedForumData.getMemberCount()), AN(feedForumData.getPostNum())));
                bVar.jjI.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.jjJ.setClickable(true);
                    bVar.jjJ.setOnClickListener(this.mOnClickListener);
                    bVar.jjJ.setTag(feedForumData);
                    bVar.jjJ.aP(false);
                    bVar.jjJ.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.jcX) {
            this.jdc.setVisibility(0);
        } else {
            this.jdc.setVisibility(8);
        }
        cHp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.jjJ != null) {
            bVar.jjJ.aP(true);
            bVar.jjJ.setEnabled(false);
        }
    }

    private String AN(int i) {
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
    public void RU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.Bq(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.jjB != null) {
                    a.this.jjB.clear();
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
        aVar.b(this.mTbPageContext).brv();
    }

    private void cHp() {
        ap.setBackgroundColor(this.jjw, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jgR, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jjz, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTvLable, R.color.CAM_X0108, 1);
        ap.setImageResource(this.jjx, R.drawable.icon_frs_recommend_arrow_down);
        ap.setViewTextColor(this.jjy, R.color.CAM_X0110, 1);
        for (b bVar : this.jjA) {
            ap.setBackgroundResource(bVar.gbq, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(bVar.jjH, R.color.CAM_X0108, 1);
            ap.setViewTextColor(bVar.jjI, R.color.CAM_X0305, 1);
            bVar.jjJ.aP(!bVar.jjJ.isEnabled());
        }
    }

    public void hide() {
        this.jjw.setVisibility(8);
    }

    public void show() {
        this.jjw.setVisibility(0);
    }
}
