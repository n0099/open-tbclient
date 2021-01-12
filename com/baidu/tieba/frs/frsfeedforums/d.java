package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> eSJ;
    private LikeModel fle;
    private List<FeedForumData> jrw;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) d.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) d.this.eSJ.getOrignalPage()).checkUpIsLogin()) {
                        d.this.fle.gq(feedForumData.getForumName(), feedForumData.getForumId());
                        aq aqVar = new aq("c10048");
                        aqVar.dW("fid", feedForumData.getForumId());
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aqVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    d.this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.eSJ.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new aq("c10050").dW("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private e iDn = new e() { // from class: com.baidu.tieba.frs.frsfeedforums.d.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bQ(d.this.fle.getErrorCode(), d.this.fle.getErrorString())) {
                AntiHelper.bs(d.this.eSJ.getPageActivity(), d.this.fle.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(d.this.fle.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), d.this.fle.getErrorString());
                }
            } else {
                w wVar = (w) obj;
                wVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
            }
        }
    };

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.eSJ = tbPageContext;
        this.fle = new LikeModel(tbPageContext);
        this.fle.setLoadDataCallBack(this.iDn);
    }

    public void setData(List<FeedForumData> list) {
        this.jrw = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jrw != null) {
            return this.jrw.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jrw != null) {
            return this.jrw.get(i);
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
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.jrE.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.ggb.setOnClickListener(this.mOnClickListener);
        bVar.jrB.setPlaceHolder(1);
        bVar.jrB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.jrB.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.jrC.setText(String.format(this.eSJ.getPageActivity().getString(R.string.attention_post_count), zt(feedForumData.getMemberCount()), zt(feedForumData.getPostNum())));
        bVar.jrD.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.jrE.setClickable(true);
            bVar.jrE.setOnClickListener(this.mOnClickListener);
            bVar.jrE.setEnabled(true);
            bVar.jrE.aM(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.akf != this.mSkinType) {
            ao.setBackgroundResource(bVar.ggb, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ao.setViewTextColor(bVar.jrC, R.color.CAM_X0108, 1);
            ao.setViewTextColor(bVar.jrD, R.color.CAM_X0305, 1);
            if (bVar.dyW != null) {
                ao.setBackgroundColor(bVar.dyW, R.color.CAM_X0204);
            }
            bVar.akf = this.mSkinType;
        }
    }

    private void a(b bVar) {
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

    public void a(List<FeedForumData> list, w wVar) {
        if (list != null && list.size() > 0 && wVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.getFid())) {
                    feedForumData.setIsLike(wVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
