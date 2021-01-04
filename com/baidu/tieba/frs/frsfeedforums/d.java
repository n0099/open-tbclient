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
    private TbPageContext<FrsMoreFeedForumsActivity> eXu;
    private LikeModel fpO;
    private List<FeedForumData> jwc;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) d.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) d.this.eXu.getOrignalPage()).checkUpIsLogin()) {
                        d.this.fpO.gr(feedForumData.getForumName(), feedForumData.getForumId());
                        aq aqVar = new aq("c10048");
                        aqVar.dX("fid", feedForumData.getForumId());
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aqVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    d.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.eXu.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new aq("c10050").dX("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private e iHU = new e() { // from class: com.baidu.tieba.frs.frsfeedforums.d.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bP(d.this.fpO.getErrorCode(), d.this.fpO.getErrorString())) {
                AntiHelper.bs(d.this.eXu.getPageActivity(), d.this.fpO.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(d.this.fpO.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), d.this.fpO.getErrorString());
                }
            } else {
                w wVar = (w) obj;
                wVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
            }
        }
    };

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.eXu = tbPageContext;
        this.fpO = new LikeModel(tbPageContext);
        this.fpO.setLoadDataCallBack(this.iHU);
    }

    public void setData(List<FeedForumData> list) {
        this.jwc = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jwc != null) {
            return this.jwc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jwc != null) {
            return this.jwc.get(i);
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
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.jwk.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.gkJ.setOnClickListener(this.mOnClickListener);
        bVar.jwh.setPlaceHolder(1);
        bVar.jwh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.jwh.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.jwi.setText(String.format(this.eXu.getPageActivity().getString(R.string.attention_post_count), AZ(feedForumData.getMemberCount()), AZ(feedForumData.getPostNum())));
        bVar.jwj.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.jwk.setClickable(true);
            bVar.jwk.setOnClickListener(this.mOnClickListener);
            bVar.jwk.setEnabled(true);
            bVar.jwk.aM(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.akW != this.mSkinType) {
            ao.setBackgroundResource(bVar.gkJ, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ao.setViewTextColor(bVar.jwi, R.color.CAM_X0108, 1);
            ao.setViewTextColor(bVar.jwj, R.color.CAM_X0305, 1);
            if (bVar.dDI != null) {
                ao.setBackgroundColor(bVar.dDI, R.color.CAM_X0204);
            }
            bVar.akW = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.jwk != null) {
            bVar.jwk.aM(true);
            bVar.jwk.setEnabled(false);
        }
    }

    private String AZ(int i) {
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
