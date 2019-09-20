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
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    private LikeModel cer;
    private List<FeedForumData> fHo;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.mContext.getOrignalPage()).checkUpIsLogin()) {
                        e.this.cer.em(feedForumData.getForumName(), feedForumData.getForumId());
                        an anVar = new an("c10048");
                        anVar.bT("fid", feedForumData.getForumId());
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(anVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new an("c10050").bT("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d eZj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(e.this.cer.getErrorCode(), e.this.cer.getErrorString())) {
                AntiHelper.aQ(e.this.mContext.getPageActivity(), e.this.cer.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.cer.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.cer.getErrorString());
                }
            } else {
                t tVar = (t) obj;
                tVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.cer = new LikeModel(tbPageContext);
        this.cer.setLoadDataCallBack(this.eZj);
    }

    public void setData(List<FeedForumData> list) {
        this.fHo = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fHo != null) {
            return this.fHo.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fHo != null) {
            return this.fHo.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.fHw.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.cZX.setOnClickListener(this.mOnClickListener);
        bVar.fHt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.fHt.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.fHu.setText(String.format(this.mContext.getPageActivity().getString(R.string.attention_post_count), sg(feedForumData.getMemberCount()), sg(feedForumData.getPostNum())));
        bVar.fHv.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.fHw.setClickable(true);
            bVar.fHw.setOnClickListener(this.mOnClickListener);
            bVar.fHw.setEnabled(true);
            bVar.fHw.ey(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ceL != this.mSkinType) {
            am.k(bVar.cZX, R.drawable.frs_like_feed_forum_item_bg);
            am.f(bVar.mTitle, R.color.cp_cont_b, 1);
            am.f(bVar.fHu, R.color.cp_cont_c, 1);
            am.f(bVar.fHv, R.color.cp_link_tip_d, 1);
            if (bVar.aOf != null) {
                am.l(bVar.aOf, R.color.cp_bg_line_c);
            }
            bVar.ceL = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.fHw != null) {
            bVar.fHw.ey(true);
            bVar.fHw.setEnabled(false);
        }
    }

    private String sg(int i) {
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

    public void a(List<FeedForumData> list, t tVar) {
        if (list != null && list.size() > 0 && tVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(tVar.getFid())) {
                    feedForumData.setIsLike(tVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
