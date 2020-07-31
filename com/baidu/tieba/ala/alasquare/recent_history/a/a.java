package com.baidu.tieba.ala.alasquare.recent_history.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    protected int fxB;
    protected Context mContext;
    protected List<com.baidu.tieba.ala.alasquare.recent_history.b.b> mData = new ArrayList();
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void setData(List<com.baidu.tieba.ala.alasquare.recent_history.b.b> list) {
        if (!x.isEmpty(list)) {
            this.mData.clear();
            this.mData.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qv */
    public com.baidu.tieba.ala.alasquare.recent_history.b.b getItem(int i) {
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbPageContext<?> tbPageContext, bv bvVar, String str) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
