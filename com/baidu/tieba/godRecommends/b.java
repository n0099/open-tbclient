package com.baidu.tieba.godRecommends;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.godMultiAttention.MultiAttentionHttpResponseMessage;
import com.baidu.tieba.godMultiAttention.MultiAttentionModel;
import com.baidu.tieba.godMultiAttention.MultiAttentionSocketResponseMessage;
import com.baidu.tieba.godRecommends.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes6.dex */
public class b implements com.baidu.tbadk.k.b {
    private GodRecommendModel gco;
    private MultiAttentionModel gcp;
    private d gcq;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.godRecommends.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            if (view.getId() == R.id.attention_btn && (view.getTag() instanceof MetaData) && (metaData = (MetaData) view.getTag()) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new an("c12525").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).bT("obj_locate", "2"));
                b.this.gcp.m(arrayList, false);
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.godRecommends.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MetaData tG = b.this.gcq.tG(i);
            if (tG != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), String.valueOf(tG.getUserId()), tG.getUserName());
                TiebaStatic.log(new an("c12525").bT(VideoPlayActivityConfig.OBJ_ID, tG.getUserId()).bT("obj_locate", "1"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            b.this.gcq.aAd();
        }
    };
    private d.a gcr = new d.a() { // from class: com.baidu.tieba.godRecommends.b.3
        @Override // com.baidu.tieba.godRecommends.d.a
        public void ct(List<MetaData> list) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : list) {
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new an("c12525").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).bT("obj_locate", "2"));
            }
            b.this.gcp.m(arrayList, true);
        }
    };
    private com.baidu.adp.framework.listener.a gcs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471) { // from class: com.baidu.tieba.godRecommends.b.4
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof GodRecommendHttpResponseMessage) || (responsedMessage instanceof GodRecommendSocketMessage)) {
                b.this.gco.bvn();
                if (responsedMessage.getError() == 0) {
                    c cVar = null;
                    if (responsedMessage instanceof GodRecommendHttpResponseMessage) {
                        cVar = ((GodRecommendHttpResponseMessage) responsedMessage).getGodRecommendData();
                    } else if (responsedMessage instanceof GodRecommendSocketMessage) {
                        cVar = ((GodRecommendSocketMessage) responsedMessage).getGodRecommendData();
                    }
                    b.this.gcq.a(cVar);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gct = new com.baidu.adp.framework.listener.a(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388) { // from class: com.baidu.tieba.godRecommends.b.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<MFollowResult> followResults;
            boolean isAttentionAll;
            if ((responsedMessage instanceof MultiAttentionHttpResponseMessage) || (responsedMessage instanceof MultiAttentionSocketResponseMessage)) {
                b.this.gcp.bvn();
                if (responsedMessage.getError() != 0) {
                    l.showToast(b.this.mPageContext.getPageActivity(), responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof MultiAttentionHttpResponseMessage) {
                    MultiAttentionHttpResponseMessage multiAttentionHttpResponseMessage = (MultiAttentionHttpResponseMessage) responsedMessage;
                    followResults = multiAttentionHttpResponseMessage.getFollowResults();
                    isAttentionAll = multiAttentionHttpResponseMessage.isAttentionAll();
                } else {
                    MultiAttentionSocketResponseMessage multiAttentionSocketResponseMessage = (MultiAttentionSocketResponseMessage) responsedMessage;
                    followResults = multiAttentionSocketResponseMessage.getFollowResults();
                    isAttentionAll = multiAttentionSocketResponseMessage.isAttentionAll();
                }
                b.this.gcq.n(followResults, isAttentionAll);
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gco = new GodRecommendModel(tbPageContext);
        this.gcp = new MultiAttentionModel(tbPageContext);
        this.gcq = new d(tbPageContext);
        this.gcq.a(this.gcr);
        this.gcq.setOnClickListener(this.mOnClickListener);
        this.gcq.setOnItemClickListener(this.mOnItemClickListener);
        aYD();
    }

    private void aYD() {
        this.mPageContext.registerListener(this.gcs);
        this.mPageContext.registerListener(this.gct);
        a(this.gcs.getHttpMessageListener(), this.gcs.getSocketMessageListener());
        a(this.gct.getHttpMessageListener(), this.gct.getSocketMessageListener());
    }

    private void a(HttpMessageListener httpMessageListener, com.baidu.adp.framework.listener.c cVar) {
        if (httpMessageListener != null) {
            httpMessageListener.setSelfListener(true);
        }
        if (cVar != null) {
            cVar.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void qL(String str) {
        this.gco.ys(str);
    }

    @Override // com.baidu.tbadk.k.b
    public void destory() {
        if (this.gco != null) {
            this.gco.destory();
        }
        if (this.gcp != null) {
            this.gcp.destory();
        }
        if (this.gcq != null) {
            this.gcq.aAd();
        }
    }
}
