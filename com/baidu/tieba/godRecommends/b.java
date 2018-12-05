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
import com.baidu.tieba.e;
import com.baidu.tieba.godMultiAttention.MultiAttentionHttpResponseMessage;
import com.baidu.tieba.godMultiAttention.MultiAttentionModel;
import com.baidu.tieba.godMultiAttention.MultiAttentionSocketResponseMessage;
import com.baidu.tieba.godRecommends.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.i.b {
    private GodRecommendModel eoa;
    private MultiAttentionModel eob;
    private d eoc;
    private TbPageContext<?> mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.godRecommends.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            if (view.getId() == e.g.attention_btn && (view.getTag() instanceof MetaData) && (metaData = (MetaData) view.getTag()) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new am("c12525").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).aA("obj_locate", "2"));
                b.this.eob.k(arrayList, false);
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.godRecommends.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MetaData oh = b.this.eoc.oh(i);
            if (oh != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), String.valueOf(oh.getUserId()), oh.getUserName());
                TiebaStatic.log(new am("c12525").aA(VideoPlayActivityConfig.OBJ_ID, oh.getUserId()).aA("obj_locate", "1"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            b.this.eoc.Tb();
        }
    };
    private d.a eod = new d.a() { // from class: com.baidu.tieba.godRecommends.b.3
        @Override // com.baidu.tieba.godRecommends.d.a
        public void cc(List<MetaData> list) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : list) {
                arrayList.add(metaData.getPortrait());
                TiebaStatic.log(new am("c12525").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).aA("obj_locate", "2"));
            }
            b.this.eob.k(arrayList, true);
        }
    };
    private com.baidu.adp.framework.listener.a eoe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471) { // from class: com.baidu.tieba.godRecommends.b.4
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof GodRecommendHttpResponseMessage) || (responsedMessage instanceof GodRecommendSocketMessage)) {
                b.this.eoa.aJx();
                if (responsedMessage.getError() == 0) {
                    c cVar = null;
                    if (responsedMessage instanceof GodRecommendHttpResponseMessage) {
                        cVar = ((GodRecommendHttpResponseMessage) responsedMessage).getGodRecommendData();
                    } else if (responsedMessage instanceof GodRecommendSocketMessage) {
                        cVar = ((GodRecommendSocketMessage) responsedMessage).getGodRecommendData();
                    }
                    b.this.eoc.a(cVar);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eog = new com.baidu.adp.framework.listener.a(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388) { // from class: com.baidu.tieba.godRecommends.b.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<MFollowResult> followResults;
            boolean isAttentionAll;
            if ((responsedMessage instanceof MultiAttentionHttpResponseMessage) || (responsedMessage instanceof MultiAttentionSocketResponseMessage)) {
                b.this.eob.aJx();
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
                b.this.eoc.l(followResults, isAttentionAll);
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eoa = new GodRecommendModel(tbPageContext);
        this.eob = new MultiAttentionModel(tbPageContext);
        this.eoc = new d(tbPageContext);
        this.eoc.a(this.eod);
        this.eoc.setOnClickListener(this.mOnClickListener);
        this.eoc.setOnItemClickListener(this.mOnItemClickListener);
        aog();
    }

    private void aog() {
        this.mPageContext.registerListener(this.eoe);
        this.mPageContext.registerListener(this.eog);
        a(this.eoe.getHttpMessageListener(), this.eoe.getSocketMessageListener());
        a(this.eog.getHttpMessageListener(), this.eog.getSocketMessageListener());
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
    public void hZ(String str) {
        this.eoa.pc(str);
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.eoa != null) {
            this.eoa.destory();
        }
        if (this.eob != null) {
            this.eob.destory();
        }
        if (this.eoc != null) {
            this.eoc.Tb();
        }
    }
}
