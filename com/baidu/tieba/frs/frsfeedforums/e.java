package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private LikeModel aHL;
    private List<FeedForumData> dMc;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == e.g.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.mContext.getOrignalPage()).checkUpIsLogin()) {
                        e.this.aHL.cF(feedForumData.getForumName(), feedForumData.getForumId());
                        am amVar = new am("c10048");
                        amVar.ax(ImageViewerConfig.FORUM_ID, feedForumData.getForumId());
                        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(amVar);
                    }
                } else if (view.getId() == e.g.frs_like_feed_forum_item) {
                    e.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new am("c10050").ax(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d did = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.ai(e.this.aHL.getErrorCode(), e.this.aHL.getErrorString())) {
                AntiHelper.aG(e.this.mContext.getPageActivity(), e.this.aHL.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.aHL.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.aHL.getErrorString());
                }
            } else {
                r rVar = (r) obj;
                rVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.aHL = new LikeModel(tbPageContext);
        this.aHL.setLoadDataCallBack(this.did);
    }

    public void setData(List<FeedForumData> list) {
        this.dMc = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dMc != null) {
            return this.dMc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dMc != null) {
            return this.dMc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.dMk.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.bzb.setOnClickListener(this.mOnClickListener);
        bVar.dMh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.dMh.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.dMi.setText(String.format(this.mContext.getPageActivity().getString(e.j.attention_post_count), mn(feedForumData.getMemberCount()), mn(feedForumData.getPostNum())));
        bVar.dMj.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.dMk.setClickable(true);
            bVar.dMk.setOnClickListener(this.mOnClickListener);
            bVar.dMk.setEnabled(true);
            bVar.dMk.bJ(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.aIf != this.mSkinType) {
            al.i(bVar.bzb, e.f.frs_like_feed_forum_item_bg);
            al.c(bVar.mTitle, e.d.cp_cont_b, 1);
            al.c(bVar.dMi, e.d.cp_cont_c, 1);
            al.c(bVar.dMj, e.d.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                al.j(bVar.mDivider, e.d.cp_bg_line_b);
            }
            bVar.aIf = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.dMk != null) {
            bVar.dMk.bJ(true);
            bVar.dMk.setEnabled(false);
        }
    }

    private String mn(int i) {
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

    public void a(List<FeedForumData> list, r rVar) {
        if (list != null && list.size() > 0 && rVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(rVar.getFid())) {
                    feedForumData.setIsLike(rVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
