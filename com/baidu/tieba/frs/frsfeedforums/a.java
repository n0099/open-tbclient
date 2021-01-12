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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
    private LikeModel fle;
    private boolean jkO;
    private View jkT;
    private View joN;
    private LinearLayout jrr;
    private ImageView jrs;
    private TextView jrt;
    private View jru;
    private List<FeedForumData> jrw;
    TbPageContext<FrsFragment> mTbPageContext;
    private TextView mTvLable;
    private List<b> jrv = new ArrayList();
    private Handler mHandler = new Handler();
    private int mType = 1;
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean jrx = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            FeedForumData feedForumData;
            String str2;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (bg.checkUpIsLogin(a.this.mTbPageContext.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.fle.gq(feedForumData.getForumName(), feedForumData.getForumId());
                    if (a.this.mType == 1) {
                        str2 = "c10028";
                    } else {
                        str2 = "c10040";
                    }
                    TiebaStatic.log(new aq(str2).dW("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.Pd();
                TiebaStatic.log(new aq("c10029").dW("fid", a.this.mForumId));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() == a.this.jrt.getId() && x.getCount(a.this.jrw) > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(a.this.mTbPageContext.getPageActivity(), (Serializable) a.this.jrw)));
                    TiebaStatic.log(new aq("c10046").dW("fid", a.this.mForumId));
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
                    TiebaStatic.log(new aq(str).dW("fid", feedForumData2.getForumId()));
                }
            }
        }
    };
    private e iDn = new e() { // from class: com.baidu.tieba.frs.frsfeedforums.a.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bQ(a.this.fle.getErrorCode(), a.this.fle.getErrorString())) {
                AntiHelper.bs(a.this.mTbPageContext.getPageActivity(), a.this.fle.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(a.this.fle.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), a.this.fle.getErrorString());
                }
            } else {
                final w wVar = (w) obj;
                if (x.getCount(a.this.jrw) > 0 && wVar != null) {
                    Iterator it = a.this.jrv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.jrE.getTag();
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
                                Iterator it2 = a.this.jrw.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    FeedForumData feedForumData2 = (FeedForumData) it2.next();
                                    if (feedForumData2.getForumId().equals(wVar.getFid())) {
                                        a.this.jrw.remove(feedForumData2);
                                        break;
                                    }
                                }
                                if (a.this.jrw.size() > 0) {
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
        this.jrr = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.joN = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.jru = view.findViewById(R.id.layout_like_feed_forum_header);
        this.mTvLable = (TextView) this.jrr.findViewById(R.id.like_feed_forums_label);
        this.jrs = (ImageView) this.jrr.findViewById(R.id.like_feed_forums_arrow);
        this.jrs.setOnClickListener(this.mOnClickListener);
        this.jrt = (TextView) this.jrr.findViewById(R.id.feed_forums_more);
        this.jkT = view.findViewById(R.id.feed_forum_bottom_line);
        this.jrt.setOnClickListener(this.mOnClickListener);
        this.fle = new LikeModel(tbPageContext);
        this.fle.setUniqueId(bdUniqueId);
        this.fle.setLoadDataCallBack(this.iDn);
        this.mType = i;
        this.jkO = z;
    }

    public void f(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.jrw = list;
        refreshUI();
        if (this.mType == 2 && !this.jrx) {
            TiebaStatic.log(new aq("c10035").dW("fid", this.mForumId));
            this.jrx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        int i;
        if (x.getCount(this.jrw) == 0) {
            hide();
            return;
        }
        show();
        int size = this.jrw.size() > 2 ? 2 : this.jrw.size();
        int size2 = size - this.jrv.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.jrr.addView(inflate);
                this.jrv.add(new b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.jrv.size() - 1;
                this.jrr.removeView(this.jrv.get(size3).ggb);
                this.jrv.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.jrw.get(i4);
            b bVar = this.jrv.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.ggb.setTag(feedForumData);
                bVar.ggb.setOnClickListener(this.mOnClickListener);
                bVar.jrB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.jrB.setPlaceHolder(1);
                bVar.jrB.startLoad(feedForumData.getAvatar(), 15, false);
                bVar.mTitle.setText(feedForumData.getForumName());
                bVar.jrC.setText(String.format(this.mTbPageContext.getPageActivity().getString(R.string.attention_post_count), zt(feedForumData.getMemberCount()), zt(feedForumData.getPostNum())));
                bVar.jrD.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.jrE.setClickable(true);
                    bVar.jrE.setOnClickListener(this.mOnClickListener);
                    bVar.jrE.setTag(feedForumData);
                    bVar.jrE.aM(false);
                    bVar.jrE.setEnabled(true);
                } else {
                    a(bVar);
                }
            }
        }
        if (this.jkO) {
            this.jkT.setVisibility(0);
        } else {
            this.jkT.setVisibility(8);
        }
        cGz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar != null && bVar.jrE != null) {
            bVar.jrE.aM(true);
            bVar.jrE.setEnabled(false);
        }
    }

    private String zt(int i) {
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
    public void Pd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.Ad(this.mTbPageContext.getPageActivity().getString(R.string.not_intrested));
        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.frs.frsfeedforums.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (a.this.jrw != null) {
                    a.this.jrw.clear();
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
        aVar.b(this.mTbPageContext).bqe();
    }

    private void cGz() {
        ao.setBackgroundColor(this.jrr, R.color.CAM_X0201);
        ao.setBackgroundColor(this.joN, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jru, R.color.CAM_X0201);
        ao.setViewTextColor(this.mTvLable, R.color.CAM_X0108, 1);
        ao.setImageResource(this.jrs, R.drawable.icon_frs_recommend_arrow_down);
        ao.setViewTextColor(this.jrt, R.color.CAM_X0110, 1);
        for (b bVar : this.jrv) {
            ao.setBackgroundResource(bVar.ggb, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ao.setViewTextColor(bVar.jrC, R.color.CAM_X0108, 1);
            ao.setViewTextColor(bVar.jrD, R.color.CAM_X0305, 1);
            bVar.jrE.aM(!bVar.jrE.isEnabled());
        }
    }

    public void hide() {
        this.jrr.setVisibility(8);
    }

    public void show() {
        this.jrr.setVisibility(0);
    }
}
