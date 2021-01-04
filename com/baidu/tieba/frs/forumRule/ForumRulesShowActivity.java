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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.frs.forumRule.a.a;
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.frs.forumRule.view.c;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements h {
    private ForumRulesShowModel jtA;
    private c jtB;
    a.InterfaceC0735a jtC = new a.InterfaceC0735a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void t(boolean z, String str) {
            if (ForumRulesShowActivity.this.jtB != null) {
                if (z) {
                    ForumRulesShowActivity.this.jtB.Lg(str);
                } else {
                    ForumRulesShowActivity.this.jtB.cKp();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void KT(String str) {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.jtB.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.jtB.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void du(List<com.baidu.tieba.frs.forumRule.b.c> list) {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.jtB.dy(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void a(com.baidu.tieba.frs.forumRule.b.a aVar) {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.jtB.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void bFH() {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.jtB.cKn();
                ForumRulesShowActivity.this.jtB.cKj();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.jtB.cKi(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0735a
        public void finish() {
            if (ForumRulesShowActivity.this.jtB != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.jtB.cKi());
                ForumRulesShowActivity.this.jtB.cKk();
                ForumRulesShowActivity.this.jtB.cKm();
                ForumRulesShowActivity.this.jtB.cKl();
            }
        }
    };
    private CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
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
        this.jtA.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jtB != null) {
            this.jtB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.jtD);
    }

    private void initData(Bundle bundle) {
        this.jtA = new ForumRulesShowModel(this);
        cJx();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.jtB = new c(this, this.mFrom);
        this.jtB.a(getRefreshView());
    }

    private void cJx() {
        this.jtA.a(this.jtC);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jtB != null) {
            this.jtB.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jtD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jtA != null) {
            this.jtA.destory();
        }
        if (this.jtB != null) {
            this.jtB.destory();
        }
    }

    public void cJy() {
        if (this.jtA != null) {
            this.jtA.cJP();
        }
    }

    public c cJz() {
        return this.jtB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.jtB.remove();
                this.jtB.mData.clear();
                this.jtA.cJP();
            }
            new BdTopToast(this, 3000).yW(true).UY(stringExtra).aR(this.jtB.getRootView());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLE() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLF() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bLG() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLH() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bLI() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bLK() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        be.bwu().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
    }
}
