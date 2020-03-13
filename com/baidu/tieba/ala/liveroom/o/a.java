package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean asS;
    private String asT;
    private PersonUserData fjA;
    private b fjB;
    private TextView fjv;
    private TextView fjw;
    private TextView fjx;
    private View fjy;
    private View fjz;
    private TextView mCancel;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0464a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bqk();

        void onCancel();

        void zk(String str);

        void zl(String str);

        void zm(String str);

        void zn(String str);

        void zo(String str);

        void zp(String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.fjv = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fjy = findViewById(a.g.ala_person_forbid_this_divider);
        this.fjw = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fjz = findViewById(a.g.ala_person_forbid_this_divider);
        this.fjx = (TextView) findViewById(a.g.ala_person_admin);
        this.mCancel = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fjv.setOnClickListener(this);
        this.fjw.setOnClickListener(this);
        this.fjx.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fjB != null) {
            if (view == this.fjv) {
                if (this.fjA != null && this.fjA.user_info != null) {
                    if (bqe()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjA != null && a.this.fjA.user_info != null) {
                                    a.this.fjA.user_info.is_block = 0;
                                    a.this.fjB.zm(a.this.fjA.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjA.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjA != null && a.this.fjA.user_info != null) {
                                a.this.fjA.user_info.is_block = 1;
                                a.this.fjB.zk(a.this.fjA.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fjA.user_info.getNameShow()));
                }
            } else if (view == this.fjw) {
                if (this.fjA != null && this.fjA.user_info != null) {
                    if (bqd()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjA != null && a.this.fjA.user_info != null) {
                                    a.this.fjA.user_info.is_block = 0;
                                    a.this.fjB.zn(a.this.fjA.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjA.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjA != null && a.this.fjA.user_info != null) {
                                a.this.fjA.user_info.is_block = 2;
                                a.this.fjB.zl(a.this.fjA.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fjA.user_info.getNameShow()));
                }
            } else if (view == this.fjx) {
                if (this.fjA != null && this.fjA.login_user_info != null) {
                    if (bqf()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjA != null && a.this.fjA.login_user_info != null) {
                                    a.this.fjA.login_user_info.is_live_admin = 1;
                                    a.this.fjB.zo(a.this.fjA.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fjA.user_info.getNameShow()));
                    } else if (bqg()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjA != null && a.this.fjA.login_user_info != null) {
                                    a.this.fjA.login_user_info.is_live_admin = 0;
                                    a.this.fjB.zp(a.this.fjA.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fjA.user_info.getNameShow()));
                    } else if (bqh()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjA != null && a.this.fjA.login_user_info != null) {
                                    a.this.fjA.login_user_info.is_live_admin = 0;
                                    a.this.fjB.bqk();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.mCancel) {
                this.fjB.onCancel();
            }
        }
    }

    private void a(final InterfaceC0464a interfaceC0464a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0464a != null) {
                    interfaceC0464a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.9
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
        this.fjA = personUserData;
        this.asS = z;
        this.asT = str;
        if (bqi() || bqj()) {
            qA(8);
            qB(8);
        } else if (bqd()) {
            qA(8);
            this.fjw.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bqe()) {
            qA(0);
            this.fjv.setText(a.i.ala_person_relieve_forbidden_this);
            this.fjw.setText(a.i.ala_person_forbid_forever);
        } else {
            qA(0);
            this.fjv.setText(a.i.ala_person_forbid_this);
            this.fjw.setText(a.i.ala_person_forbid_forever);
        }
        if (bqc()) {
            this.fjx.setVisibility(8);
            this.fjz.setVisibility(8);
        } else if (bqg()) {
            this.fjx.setText(a.i.ala_person_fire_admin);
        } else if (bqf()) {
            this.fjx.setText(a.i.ala_person_appoint_admin);
        } else if (bqi() && bqh()) {
            this.fjx.setText(a.i.ala_person_resign_admin);
        } else {
            this.fjx.setVisibility(8);
            this.fjz.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fjB = bVar;
    }

    private boolean bqc() {
        return (this.fjA == null || this.fjA.user_info == null || this.fjA.user_info.is_block <= 0) ? false : true;
    }

    private boolean bqd() {
        return (this.fjA == null || this.fjA.user_info == null || this.fjA.user_info.is_block != 2) ? false : true;
    }

    private boolean bqe() {
        return (this.fjA == null || this.fjA.user_info == null || this.fjA.user_info.is_block != 1) ? false : true;
    }

    private boolean bqf() {
        return this.fjA != null && this.fjA.user_info != null && this.asS && this.fjA.user_info.is_live_admin == 0;
    }

    private boolean bqg() {
        return this.fjA != null && this.fjA.user_info != null && this.asS && this.fjA.user_info.is_live_admin == 1;
    }

    private boolean bqh() {
        return (this.fjA == null || this.fjA.login_user_info == null || this.asS || this.fjA.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bqi() {
        return (this.fjA == null || this.fjA.user_info == null || TextUtils.isEmpty(this.asT) || !this.asT.equals(this.fjA.user_info.user_id)) ? false : true;
    }

    private boolean bqj() {
        return (this.fjA == null || this.fjA.user_info == null || this.fjA.user_info.is_live_admin != 1) ? false : true;
    }

    private void qA(int i) {
        this.fjv.setVisibility(i);
        this.fjy.setVisibility(i);
    }

    private void qB(int i) {
        this.fjw.setVisibility(i);
        this.fjz.setVisibility(i);
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
