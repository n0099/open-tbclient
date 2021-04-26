package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import d.a.i0.f0.i;
import d.a.j0.e1.f.j.g;
import java.util.List;
/* loaded from: classes4.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    public OfficialBarFeedMsglistView feedView;
    public String forumId;
    public g model;
    public byte source;
    public i mTopToastEventListener = new a();
    public g.d onDataLoadListener = new b();

    /* loaded from: classes4.dex */
    public class a extends i<TopToastEvent> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.f0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            if (SingleForumBroadcastFeedActivity.this.feedView != null) {
                SingleForumBroadcastFeedActivity.this.feedView.o(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements g.d {
        public b() {
        }

        @Override // d.a.j0.e1.f.j.g.d
        public void a(List<d.a.j0.e1.l.c.b> list) {
            SingleForumBroadcastFeedActivity.this.feedView.l(list, null);
        }

        @Override // d.a.j0.e1.f.j.g.d
        public void onReadCountLoad(LongSparseArray<d.a.j0.e1.i.a.b.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.feedView.m(longSparseArray);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.feedView.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g gVar = new g(getPageContext());
        this.model = gVar;
        gVar.i(this.onDataLoadListener);
        this.feedView = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.source = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.model.f(this.forumId);
            this.feedView.p(this.forumId, System.currentTimeMillis());
        }
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.model;
        if (gVar != null) {
            gVar.e();
        }
        unRegisterResponsedEventListener();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        StatisticItem statisticItem = new StatisticItem("c13870");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.forumId);
        statisticItem.param("obj_source", (int) this.source);
        TiebaStatic.log(statisticItem);
    }
}
