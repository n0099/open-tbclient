package com.baidu.tieba.ala.liveroom.q;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aDB;
    private TextView bYe;
    private boolean bnF;
    private TextView hNj;
    private TextView hNk;
    private TextView hNl;
    private View hNm;
    private View hNn;
    private PersonUserData hNo;
    private b hNp;
    private int hNq;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0672a {
        void onConfirm();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void aM(String str, int i);

        void aN(String str, int i);

        void aO(String str, int i);

        void aP(String str, int i);

        void aQ(String str, int i);

        void aR(String str, int i);

        void onCancel();

        void we(int i);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.hNq = 0;
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hNj = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hNm = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNk = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hNn = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNl = (TextView) findViewById(a.f.ala_person_admin);
        this.bYe = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hNj.setOnClickListener(this);
        this.hNk.setOnClickListener(this);
        this.hNl.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hNp != null) {
            if (view == this.hNj) {
                if (this.hNo != null && this.hNo.user_info != null) {
                    if (ckk()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    a.this.hNo.user_info.is_block = 0;
                                    a.this.hNp.aO(a.this.hNo.user_info.user_id, a.this.hNq);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNo.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                        public void onConfirm() {
                            if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                a.this.hNo.user_info.is_block = 1;
                                a.this.hNp.aM(a.this.hNo.user_info.user_id, a.this.hNq);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hNo.user_info.getNameShow()));
                }
            } else if (view == this.hNk) {
                if (this.hNo != null && this.hNo.user_info != null) {
                    if (ckj()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    a.this.hNo.user_info.is_block = 0;
                                    a.this.hNp.aP(a.this.hNo.user_info.user_id, a.this.hNq);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNo.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.4
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                        public void onConfirm() {
                            if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                a.this.hNo.user_info.is_block = 2;
                                a.this.hNp.aN(a.this.hNo.user_info.user_id, a.this.hNq);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hNo.user_info.getNameShow()));
                }
            } else if (view == this.hNl) {
                if (this.hNo != null && this.hNo.login_user_info != null) {
                    if (ckl()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.5
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.login_user_info != null) {
                                    a.this.hNo.login_user_info.is_live_admin = 1;
                                    a.this.hNp.aQ(a.this.hNo.user_info.user_id, a.this.hNq);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hNo.user_info.getNameShow()));
                    } else if (ckm()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.6
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.login_user_info != null) {
                                    a.this.hNo.login_user_info.is_live_admin = 0;
                                    a.this.hNp.aR(a.this.hNo.user_info.user_id, a.this.hNq);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hNo.user_info.getNameShow()));
                    } else if (ckn()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.q.a.7
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0672a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.login_user_info != null) {
                                    a.this.hNo.login_user_info.is_live_admin = 0;
                                    a.this.hNp.we(a.this.hNq);
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bYe) {
                this.hNp.onCancel();
            }
        }
    }

    private void a(final InterfaceC0672a interfaceC0672a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0672a != null) {
                    interfaceC0672a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.hNo = personUserData;
        this.bnF = z;
        this.aDB = str;
        if (this.hNo != null && this.hNo.user_info != null && this.hNo.user_info.extInfoJson != null) {
            if (this.hNo.user_info.extInfoJson.optInt("is_mysterious_man") == 1) {
                this.hNq = 1;
            }
        }
        if (cko() || ckp()) {
            wc(8);
            wd(8);
        } else if (ckj()) {
            wc(8);
            this.hNk.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckk()) {
            wc(0);
            this.hNj.setText(a.h.ala_person_relieve_forbidden_this);
            this.hNk.setText(a.h.ala_person_forbid_forever);
        } else {
            wc(0);
            this.hNj.setText(a.h.ala_person_forbid_this);
            this.hNk.setText(a.h.ala_person_forbid_forever);
        }
        if (cki()) {
            this.hNl.setVisibility(8);
            this.hNn.setVisibility(8);
        } else if (ckm()) {
            this.hNl.setText(a.h.ala_person_fire_admin);
        } else if (ckl()) {
            this.hNl.setText(a.h.ala_person_appoint_admin);
        } else if (cko() && ckn()) {
            this.hNl.setText(a.h.ala_person_resign_admin);
        } else {
            this.hNl.setVisibility(8);
            this.hNn.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hNp = bVar;
    }

    private boolean cki() {
        return (this.hNo == null || this.hNo.user_info == null || this.hNo.user_info.is_block <= 0) ? false : true;
    }

    private boolean ckj() {
        return (this.hNo == null || this.hNo.user_info == null || this.hNo.user_info.is_block != 2) ? false : true;
    }

    private boolean ckk() {
        return (this.hNo == null || this.hNo.user_info == null || this.hNo.user_info.is_block != 1) ? false : true;
    }

    private boolean ckl() {
        return this.hNo != null && this.hNo.user_info != null && this.bnF && this.hNo.user_info.is_live_admin == 0;
    }

    private boolean ckm() {
        return this.hNo != null && this.hNo.user_info != null && this.bnF && this.hNo.user_info.is_live_admin == 1;
    }

    private boolean ckn() {
        return (this.hNo == null || this.hNo.login_user_info == null || this.bnF || this.hNo.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cko() {
        return (this.hNo == null || this.hNo.user_info == null || TextUtils.isEmpty(this.aDB) || !this.aDB.equals(this.hNo.user_info.user_id)) ? false : true;
    }

    private boolean ckp() {
        return (this.hNo == null || this.hNo.user_info == null || this.hNo.user_info.is_live_admin != 1) ? false : true;
    }

    private void wc(int i) {
        this.hNj.setVisibility(i);
        this.hNm.setVisibility(i);
    }

    private void wd(int i) {
        this.hNk.setVisibility(i);
        this.hNn.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
