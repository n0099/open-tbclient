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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import com.baidu.tieba.godMultiAttention.MultiAttentionHttpResponseMessage;
import com.baidu.tieba.godMultiAttention.MultiAttentionModel;
import com.baidu.tieba.godMultiAttention.MultiAttentionSocketResponseMessage;
import com.baidu.tieba.godRecommends.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes6.dex */
public class b implements com.baidu.tbadk.k.b {
    private GodRecommendModel fDW;
    private MultiAttentionModel fDX;
    private d fDY;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.godRecommends.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            if (view.getId() == d.g.attention_btn && (view.getTag() instanceof MetaData) && (metaData = (MetaData) view.getTag()) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new am("c12525").bJ(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).bJ("obj_locate", "2"));
                b.this.fDX.m(arrayList, false);
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.godRecommends.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MetaData se = b.this.fDY.se(i);
            if (se != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), String.valueOf(se.getUserId()), se.getUserName());
                TiebaStatic.log(new am("c12525").bJ(VideoPlayActivityConfig.OBJ_ID, se.getUserId()).bJ("obj_locate", "1"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            b.this.fDY.aty();
        }
    };
    private d.a fDZ = new d.a() { // from class: com.baidu.tieba.godRecommends.b.3
        @Override // com.baidu.tieba.godRecommends.d.a
        public void co(List<MetaData> list) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : list) {
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new am("c12525").bJ(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).bJ("obj_locate", "2"));
            }
            b.this.fDX.m(arrayList, true);
        }
    };
    private com.baidu.adp.framework.listener.a fEa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471) { // from class: com.baidu.tieba.godRecommends.b.4
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof GodRecommendHttpResponseMessage) || (responsedMessage instanceof GodRecommendSocketMessage)) {
                b.this.fDW.bkR();
                if (responsedMessage.getError() == 0) {
                    c cVar = null;
                    if (responsedMessage instanceof GodRecommendHttpResponseMessage) {
                        cVar = ((GodRecommendHttpResponseMessage) responsedMessage).getGodRecommendData();
                    } else if (responsedMessage instanceof GodRecommendSocketMessage) {
                        cVar = ((GodRecommendSocketMessage) responsedMessage).getGodRecommendData();
                    }
                    b.this.fDY.a(cVar);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fEb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388) { // from class: com.baidu.tieba.godRecommends.b.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<MFollowResult> followResults;
            boolean isAttentionAll;
            if ((responsedMessage instanceof MultiAttentionHttpResponseMessage) || (responsedMessage instanceof MultiAttentionSocketResponseMessage)) {
                b.this.fDX.bkR();
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
                b.this.fDY.n(followResults, isAttentionAll);
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fDW = new GodRecommendModel(tbPageContext);
        this.fDX = new MultiAttentionModel(tbPageContext);
        this.fDY = new d(tbPageContext);
        this.fDY.a(this.fDZ);
        this.fDY.setOnClickListener(this.mOnClickListener);
        this.fDY.setOnItemClickListener(this.mOnItemClickListener);
        aPQ();
    }

    private void aPQ() {
        this.mPageContext.registerListener(this.fEa);
        this.mPageContext.registerListener(this.fEb);
        a(this.fEa.getHttpMessageListener(), this.fEa.getSocketMessageListener());
        a(this.fEb.getHttpMessageListener(), this.fEb.getSocketMessageListener());
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
    public void pb(String str) {
        this.fDW.vX(str);
    }

    @Override // com.baidu.tbadk.k.b
    public void destory() {
        if (this.fDW != null) {
            this.fDW.destory();
        }
        if (this.fDX != null) {
            this.fDX.destory();
        }
        if (this.fDY != null) {
            this.fDY.aty();
        }
    }
}
