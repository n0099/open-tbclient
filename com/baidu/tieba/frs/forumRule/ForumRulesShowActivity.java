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
    private ForumRulesShowModel jha;
    private c jhb;
    a.InterfaceC0742a jhc = new a.InterfaceC0742a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void t(boolean z, String str) {
            if (ForumRulesShowActivity.this.jhb != null) {
                if (z) {
                    ForumRulesShowActivity.this.jhb.Lg(str);
                } else {
                    ForumRulesShowActivity.this.jhb.cHp();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void KT(String str) {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.jhb.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.jhb.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void dm(List<com.baidu.tieba.frs.forumRule.c.c> list) {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.jhb.dq(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void a(com.baidu.tieba.frs.forumRule.c.a aVar) {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.jhb.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void bDm() {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.jhb.cHn();
                ForumRulesShowActivity.this.jhb.cHk();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.jhb.cHj(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.b.a.InterfaceC0742a
        public void finish() {
            if (ForumRulesShowActivity.this.jhb != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.jhb.cHj());
                ForumRulesShowActivity.this.jhb.cHl();
                ForumRulesShowActivity.this.jhb.cHm();
                ForumRulesShowActivity.this.jhb.setData();
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
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
        this.jha.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jhb != null) {
            this.jhb.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.jhd);
    }

    private void initData(Bundle bundle) {
        this.jha = new ForumRulesShowModel(this);
        cGy();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.jhb = new c(this, this.mFrom);
        this.jhb.a(getRefreshView());
    }

    private void cGy() {
        this.jha.a(this.jhc);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jhb != null) {
            this.jhb.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jhd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jha != null) {
            this.jha.destory();
        }
        if (this.jhb != null) {
            this.jhb.destory();
        }
    }

    public void cGz() {
        if (this.jha != null) {
            this.jha.sendMessage();
        }
    }

    public c cGA() {
        return this.jhb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.jhb.remove();
                this.jhb.mData.clear();
                this.jha.sendMessage();
            }
            new BdTopToast(this, 3000).yW(true).Vt(stringExtra).aF(this.jhb.getRootView());
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
