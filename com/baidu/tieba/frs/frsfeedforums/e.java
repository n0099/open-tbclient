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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    private LikeModel cdr;
    private List<FeedForumData> fEL;
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
                        e.this.cdr.el(feedForumData.getForumName(), feedForumData.getForumId());
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
    private com.baidu.adp.base.d eXt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aG(e.this.cdr.getErrorCode(), e.this.cdr.getErrorString())) {
                AntiHelper.aJ(e.this.mContext.getPageActivity(), e.this.cdr.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.cdr.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.cdr.getErrorString());
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
        this.cdr = new LikeModel(tbPageContext);
        this.cdr.setLoadDataCallBack(this.eXt);
    }

    public void setData(List<FeedForumData> list) {
        this.fEL = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEL != null) {
            return this.fEL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fEL != null) {
            return this.fEL.get(i);
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
            bVar2.fET.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.cYf.setOnClickListener(this.mOnClickListener);
        bVar.fEQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.fEQ.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.fER.setText(String.format(this.mContext.getPageActivity().getString(R.string.attention_post_count), sa(feedForumData.getMemberCount()), sa(feedForumData.getPostNum())));
        bVar.fES.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.fET.setClickable(true);
            bVar.fET.setOnClickListener(this.mOnClickListener);
            bVar.fET.setEnabled(true);
            bVar.fET.ev(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.cdL != this.mSkinType) {
            am.k(bVar.cYf, R.drawable.frs_like_feed_forum_item_bg);
            am.f(bVar.mTitle, R.color.cp_cont_b, 1);
            am.f(bVar.fER, R.color.cp_cont_c, 1);
            am.f(bVar.fES, R.color.cp_link_tip_d, 1);
            if (bVar.aNH != null) {
                am.l(bVar.aNH, R.color.cp_bg_line_b);
            }
            bVar.cdL = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.fET != null) {
            bVar.fET.ev(true);
            bVar.fET.setEnabled(false);
        }
    }

    private String sa(int i) {
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
