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
    private boolean atc;
    private String atd;
    private TextView fjU;
    private TextView fjV;
    private TextView fjW;
    private View fjX;
    private View fjY;
    private PersonUserData fjZ;
    private b fka;
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
        void bqp();

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
        this.fjU = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fjX = findViewById(a.g.ala_person_forbid_this_divider);
        this.fjV = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fjY = findViewById(a.g.ala_person_forbid_this_divider);
        this.fjW = (TextView) findViewById(a.g.ala_person_admin);
        this.mCancel = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fjU.setOnClickListener(this);
        this.fjV.setOnClickListener(this);
        this.fjW.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fka != null) {
            if (view == this.fjU) {
                if (this.fjZ != null && this.fjZ.user_info != null) {
                    if (bqj()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjZ != null && a.this.fjZ.user_info != null) {
                                    a.this.fjZ.user_info.is_block = 0;
                                    a.this.fka.zm(a.this.fjZ.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjZ.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjZ != null && a.this.fjZ.user_info != null) {
                                a.this.fjZ.user_info.is_block = 1;
                                a.this.fka.zk(a.this.fjZ.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fjZ.user_info.getNameShow()));
                }
            } else if (view == this.fjV) {
                if (this.fjZ != null && this.fjZ.user_info != null) {
                    if (bqi()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjZ != null && a.this.fjZ.user_info != null) {
                                    a.this.fjZ.user_info.is_block = 0;
                                    a.this.fka.zn(a.this.fjZ.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjZ.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjZ != null && a.this.fjZ.user_info != null) {
                                a.this.fjZ.user_info.is_block = 2;
                                a.this.fka.zl(a.this.fjZ.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fjZ.user_info.getNameShow()));
                }
            } else if (view == this.fjW) {
                if (this.fjZ != null && this.fjZ.login_user_info != null) {
                    if (bqk()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjZ != null && a.this.fjZ.login_user_info != null) {
                                    a.this.fjZ.login_user_info.is_live_admin = 1;
                                    a.this.fka.zo(a.this.fjZ.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fjZ.user_info.getNameShow()));
                    } else if (bql()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjZ != null && a.this.fjZ.login_user_info != null) {
                                    a.this.fjZ.login_user_info.is_live_admin = 0;
                                    a.this.fka.zp(a.this.fjZ.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fjZ.user_info.getNameShow()));
                    } else if (bqm()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjZ != null && a.this.fjZ.login_user_info != null) {
                                    a.this.fjZ.login_user_info.is_live_admin = 0;
                                    a.this.fka.bqp();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.mCancel) {
                this.fka.onCancel();
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
        this.fjZ = personUserData;
        this.atc = z;
        this.atd = str;
        if (bqn() || bqo()) {
            qC(8);
            qD(8);
        } else if (bqi()) {
            qC(8);
            this.fjV.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bqj()) {
            qC(0);
            this.fjU.setText(a.i.ala_person_relieve_forbidden_this);
            this.fjV.setText(a.i.ala_person_forbid_forever);
        } else {
            qC(0);
            this.fjU.setText(a.i.ala_person_forbid_this);
            this.fjV.setText(a.i.ala_person_forbid_forever);
        }
        if (bqh()) {
            this.fjW.setVisibility(8);
            this.fjY.setVisibility(8);
        } else if (bql()) {
            this.fjW.setText(a.i.ala_person_fire_admin);
        } else if (bqk()) {
            this.fjW.setText(a.i.ala_person_appoint_admin);
        } else if (bqn() && bqm()) {
            this.fjW.setText(a.i.ala_person_resign_admin);
        } else {
            this.fjW.setVisibility(8);
            this.fjY.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fka = bVar;
    }

    private boolean bqh() {
        return (this.fjZ == null || this.fjZ.user_info == null || this.fjZ.user_info.is_block <= 0) ? false : true;
    }

    private boolean bqi() {
        return (this.fjZ == null || this.fjZ.user_info == null || this.fjZ.user_info.is_block != 2) ? false : true;
    }

    private boolean bqj() {
        return (this.fjZ == null || this.fjZ.user_info == null || this.fjZ.user_info.is_block != 1) ? false : true;
    }

    private boolean bqk() {
        return this.fjZ != null && this.fjZ.user_info != null && this.atc && this.fjZ.user_info.is_live_admin == 0;
    }

    private boolean bql() {
        return this.fjZ != null && this.fjZ.user_info != null && this.atc && this.fjZ.user_info.is_live_admin == 1;
    }

    private boolean bqm() {
        return (this.fjZ == null || this.fjZ.login_user_info == null || this.atc || this.fjZ.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bqn() {
        return (this.fjZ == null || this.fjZ.user_info == null || TextUtils.isEmpty(this.atd) || !this.atd.equals(this.fjZ.user_info.user_id)) ? false : true;
    }

    private boolean bqo() {
        return (this.fjZ == null || this.fjZ.user_info == null || this.fjZ.user_info.is_live_admin != 1) ? false : true;
    }

    private void qC(int i) {
        this.fjU.setVisibility(i);
        this.fjX.setVisibility(i);
    }

    private void qD(int i) {
        this.fjV.setVisibility(i);
        this.fjY.setVisibility(i);
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
