package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.frs.forumRule.b.a;
import com.baidu.tieba.frs.forumRule.c.b;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.frs.forumRule.view.c;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
/* loaded from: classes22.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements h {
    private ForumRulesShowModel jgY;
    private c jgZ;
    a.InterfaceC0742a jha = new a.InterfaceC0742a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void t(boolean z, String str) {
            if (ForumRulesShowActivity.this.jgZ != null) {
                if (z) {
                    ForumRulesShowActivity.this.jgZ.Lg(str);
                } else {
                    ForumRulesShowActivity.this.jgZ.cHo();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void KT(String str) {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.jgZ.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.jgZ.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void dm(List<com.baidu.tieba.frs.forumRule.c.c> list) {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.jgZ.dq(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void a(com.baidu.tieba.frs.forumRule.c.a aVar) {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.jgZ.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void bDm() {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.jgZ.cHm();
                ForumRulesShowActivity.this.jgZ.cHj();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.jgZ.cHi(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void finish() {
            if (ForumRulesShowActivity.this.jgZ != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.jgZ.cHi());
                ForumRulesShowActivity.this.jgZ.cHk();
                ForumRulesShowActivity.this.jgZ.cHl();
                ForumRulesShowActivity.this.jgZ.setData();
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(ForumRulesShowActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initView();
        this.jgY.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgZ != null) {
            this.jgZ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.jhb);
    }

    private void initData(Bundle bundle) {
        this.jgY = new ForumRulesShowModel(this);
        cGx();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.jgZ = new c(this, this.mFrom);
        this.jgZ.a(getRefreshView());
    }

    private void cGx() {
        this.jgY.a(this.jha);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jgZ != null) {
            this.jgZ.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jhb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jgY != null) {
            this.jgY.destory();
        }
        if (this.jgZ != null) {
            this.jgZ.destory();
        }
    }

    public void cGy() {
        if (this.jgY != null) {
            this.jgY.sendMessage();
        }
    }

    public c cGz() {
        return this.jgZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.jgZ.remove();
                this.jgZ.mData.clear();
                this.jgY.sendMessage();
            }
            new BdTopToast(this, 3000).yW(true).Vt(stringExtra).aF(this.jgZ.getRootView());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bJn() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bJo() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bJp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bJq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        bf.bua().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
    }
}
