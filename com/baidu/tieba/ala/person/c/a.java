package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.person.c.c;
/* loaded from: classes3.dex */
public class a {
    private InterfaceC0591a gzc;
    private com.baidu.live.n.a gzd;
    private c gze;
    private c gzf;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0591a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gze = new c(tbPageContext);
        this.gzf = new c(tbPageContext);
        this.gze.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.gzc != null) {
                    a.this.gzc.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.gzf.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.gzc != null) {
                    a.this.gzc.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gzc != null) {
                this.gzc.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.gzd = new com.baidu.live.n.a(new com.baidu.live.n.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.n.c
            public void a(PersonUserData personUserData) {
                if (a.this.gzc != null) {
                    a.this.gzc.c(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.n.c
            public void q(int i, String str6) {
                if (a.this.gzc != null) {
                    a.this.gzc.onFail(str6);
                }
            }
        });
        this.gzd.execute(str, str2, str3, str4, str5);
        dO(str, str4);
    }

    public void dO(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.gze.setPn(-1);
            this.gze.h(0, str, str2);
            this.gzf.setPn(-1);
            this.gzf.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.gzd != null && !this.gzd.isCancelled()) {
            this.gzd.cancel();
        }
        if (this.gzc != null) {
            this.gzc.onFail(null);
        }
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.gzc = interfaceC0591a;
    }
}
