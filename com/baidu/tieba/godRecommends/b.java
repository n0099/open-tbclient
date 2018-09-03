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
import com.baidu.tieba.f;
import com.baidu.tieba.godMultiAttention.MultiAttentionHttpResponseMessage;
import com.baidu.tieba.godMultiAttention.MultiAttentionModel;
import com.baidu.tieba.godMultiAttention.MultiAttentionSocketResponseMessage;
import com.baidu.tieba.godRecommends.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.i.b {
    private GodRecommendModel dQB;
    private MultiAttentionModel dQC;
    private d dQD;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.godRecommends.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            if (view.getId() == f.g.attention_btn && (view.getTag() instanceof MetaData) && (metaData = (MetaData) view.getTag()) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new an("c12525").ae(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).ae("obj_locate", "2"));
                b.this.dQC.i(arrayList, false);
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.godRecommends.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MetaData mt = b.this.dQD.mt(i);
            if (mt != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), String.valueOf(mt.getUserId()), mt.getUserName());
                TiebaStatic.log(new an("c12525").ae(VideoPlayActivityConfig.OBJ_ID, mt.getUserId()).ae("obj_locate", "1"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            b.this.dQD.ZD();
        }
    };
    private d.a dQE = new d.a() { // from class: com.baidu.tieba.godRecommends.b.3
        @Override // com.baidu.tieba.godRecommends.d.a
        public void bJ(List<MetaData> list) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : list) {
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new an("c12525").ae(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).ae("obj_locate", "2"));
            }
            b.this.dQC.i(arrayList, true);
        }
    };
    private com.baidu.adp.framework.listener.a dQF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471) { // from class: com.baidu.tieba.godRecommends.b.4
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof GodRecommendHttpResponseMessage) || (responsedMessage instanceof GodRecommendSocketMessage)) {
                b.this.dQB.aCD();
                if (responsedMessage.getError() == 0) {
                    c cVar = null;
                    if (responsedMessage instanceof GodRecommendHttpResponseMessage) {
                        cVar = ((GodRecommendHttpResponseMessage) responsedMessage).getGodRecommendData();
                    } else if (responsedMessage instanceof GodRecommendSocketMessage) {
                        cVar = ((GodRecommendSocketMessage) responsedMessage).getGodRecommendData();
                    }
                    b.this.dQD.a(cVar);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a dQG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388) { // from class: com.baidu.tieba.godRecommends.b.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<MFollowResult> followResults;
            boolean isAttentionAll;
            if ((responsedMessage instanceof MultiAttentionHttpResponseMessage) || (responsedMessage instanceof MultiAttentionSocketResponseMessage)) {
                b.this.dQC.aCD();
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
                b.this.dQD.j(followResults, isAttentionAll);
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dQB = new GodRecommendModel(tbPageContext);
        this.dQC = new MultiAttentionModel(tbPageContext);
        this.dQD = new d(tbPageContext);
        this.dQD.a(this.dQE);
        this.dQD.setOnClickListener(this.mOnClickListener);
        this.dQD.setOnItemClickListener(this.mOnItemClickListener);
        ahE();
    }

    private void ahE() {
        this.mPageContext.registerListener(this.dQF);
        this.mPageContext.registerListener(this.dQG);
        a(this.dQF.getHttpMessageListener(), this.dQF.getSocketMessageListener());
        a(this.dQG.getHttpMessageListener(), this.dQG.getSocketMessageListener());
    }

    private void a(HttpMessageListener httpMessageListener, com.baidu.adp.framework.listener.c cVar) {
        if (httpMessageListener != null) {
            httpMessageListener.setSelfListener(true);
        }
        if (cVar != null) {
            cVar.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void gX(String str) {
        this.dQB.nq(str);
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.dQB != null) {
            this.dQB.destory();
        }
        if (this.dQC != null) {
            this.dQC.destory();
        }
        if (this.dQD != null) {
            this.dQD.ZD();
        }
    }
}
