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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends BaseAdapter {
    private LikeModel eLp;
    private TbPageContext<FrsMoreFeedForumsActivity> etO;
    private List<FeedForumData> iCX;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.etO.getOrignalPage()).checkUpIsLogin()) {
                        e.this.eLp.gk(feedForumData.getForumName(), feedForumData.getForumId());
                        aq aqVar = new aq("c10048");
                        aqVar.dK("fid", feedForumData.getForumId());
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aqVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.etO.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new aq("c10050").dK("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hRA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bM(e.this.eLp.getErrorCode(), e.this.eLp.getErrorString())) {
                AntiHelper.bk(e.this.etO.getPageActivity(), e.this.eLp.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.eLp.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.eLp.getErrorString());
                }
            } else {
                v vVar = (v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.etO = tbPageContext;
        this.eLp = new LikeModel(tbPageContext);
        this.eLp.setLoadDataCallBack(this.hRA);
    }

    public void setData(List<FeedForumData> list) {
        this.iCX = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iCX != null) {
            return this.iCX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iCX != null) {
            return this.iCX.get(i);
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
            view = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.iDf.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.fFo.setOnClickListener(this.mOnClickListener);
        bVar.iDc.setPlaceHolder(1);
        bVar.iDc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.iDc.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.iDd.setText(String.format(this.etO.getPageActivity().getString(R.string.attention_post_count), yV(feedForumData.getMemberCount()), yV(feedForumData.getPostNum())));
        bVar.iDe.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.iDf.setClickable(true);
            bVar.iDf.setOnClickListener(this.mOnClickListener);
            bVar.iDf.setEnabled(true);
            bVar.iDf.aN(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ajp != this.mSkinType) {
            ap.setBackgroundResource(bVar.fFo, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.iDd, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.iDe, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                ap.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.ajp = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.iDf != null) {
            bVar.iDf.aN(true);
            bVar.iDf.setEnabled(false);
        }
    }

    private String yV(int i) {
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

    public void a(List<FeedForumData> list, v vVar) {
        if (list != null && list.size() > 0 && vVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(vVar.getFid())) {
                    feedForumData.setIsLike(vVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
