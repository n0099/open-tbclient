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
    private TextView hMV;
    private TextView hMW;
    private TextView hMX;
    private View hMY;
    private View hMZ;
    private PersonUserData hNa;
    private b hNb;
    private int hNc;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0671a {
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
        this.hNc = 0;
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hMV = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hMY = findViewById(a.f.ala_person_forbid_this_divider);
        this.hMW = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hMZ = findViewById(a.f.ala_person_forbid_this_divider);
        this.hMX = (TextView) findViewById(a.f.ala_person_admin);
        this.bYe = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hMV.setOnClickListener(this);
        this.hMW.setOnClickListener(this);
        this.hMX.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hNb != null) {
            if (view == this.hMV) {
                if (this.hNa != null && this.hNa.user_info != null) {
                    if (ckd()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    a.this.hNa.user_info.is_block = 0;
                                    a.this.hNb.aO(a.this.hNa.user_info.user_id, a.this.hNc);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNa.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                        public void onConfirm() {
                            if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                a.this.hNa.user_info.is_block = 1;
                                a.this.hNb.aM(a.this.hNa.user_info.user_id, a.this.hNc);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hNa.user_info.getNameShow()));
                }
            } else if (view == this.hMW) {
                if (this.hNa != null && this.hNa.user_info != null) {
                    if (ckc()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    a.this.hNa.user_info.is_block = 0;
                                    a.this.hNb.aP(a.this.hNa.user_info.user_id, a.this.hNc);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNa.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.4
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                        public void onConfirm() {
                            if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                a.this.hNa.user_info.is_block = 2;
                                a.this.hNb.aN(a.this.hNa.user_info.user_id, a.this.hNc);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hNa.user_info.getNameShow()));
                }
            } else if (view == this.hMX) {
                if (this.hNa != null && this.hNa.login_user_info != null) {
                    if (cke()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.5
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.login_user_info != null) {
                                    a.this.hNa.login_user_info.is_live_admin = 1;
                                    a.this.hNb.aQ(a.this.hNa.user_info.user_id, a.this.hNc);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hNa.user_info.getNameShow()));
                    } else if (ckf()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.6
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.login_user_info != null) {
                                    a.this.hNa.login_user_info.is_live_admin = 0;
                                    a.this.hNb.aR(a.this.hNa.user_info.user_id, a.this.hNc);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hNa.user_info.getNameShow()));
                    } else if (ckg()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.q.a.7
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.login_user_info != null) {
                                    a.this.hNa.login_user_info.is_live_admin = 0;
                                    a.this.hNb.we(a.this.hNc);
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bYe) {
                this.hNb.onCancel();
            }
        }
    }

    private void a(final InterfaceC0671a interfaceC0671a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0671a != null) {
                    interfaceC0671a.onConfirm();
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
        this.hNa = personUserData;
        this.bnF = z;
        this.aDB = str;
        if (this.hNa != null && this.hNa.user_info != null && this.hNa.user_info.extInfoJson != null) {
            if (this.hNa.user_info.extInfoJson.optInt("is_mysterious_man") == 1) {
                this.hNc = 1;
            }
        }
        if (ckh() || cki()) {
            wc(8);
            wd(8);
        } else if (ckc()) {
            wc(8);
            this.hMW.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckd()) {
            wc(0);
            this.hMV.setText(a.h.ala_person_relieve_forbidden_this);
            this.hMW.setText(a.h.ala_person_forbid_forever);
        } else {
            wc(0);
            this.hMV.setText(a.h.ala_person_forbid_this);
            this.hMW.setText(a.h.ala_person_forbid_forever);
        }
        if (ckb()) {
            this.hMX.setVisibility(8);
            this.hMZ.setVisibility(8);
        } else if (ckf()) {
            this.hMX.setText(a.h.ala_person_fire_admin);
        } else if (cke()) {
            this.hMX.setText(a.h.ala_person_appoint_admin);
        } else if (ckh() && ckg()) {
            this.hMX.setText(a.h.ala_person_resign_admin);
        } else {
            this.hMX.setVisibility(8);
            this.hMZ.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hNb = bVar;
    }

    private boolean ckb() {
        return (this.hNa == null || this.hNa.user_info == null || this.hNa.user_info.is_block <= 0) ? false : true;
    }

    private boolean ckc() {
        return (this.hNa == null || this.hNa.user_info == null || this.hNa.user_info.is_block != 2) ? false : true;
    }

    private boolean ckd() {
        return (this.hNa == null || this.hNa.user_info == null || this.hNa.user_info.is_block != 1) ? false : true;
    }

    private boolean cke() {
        return this.hNa != null && this.hNa.user_info != null && this.bnF && this.hNa.user_info.is_live_admin == 0;
    }

    private boolean ckf() {
        return this.hNa != null && this.hNa.user_info != null && this.bnF && this.hNa.user_info.is_live_admin == 1;
    }

    private boolean ckg() {
        return (this.hNa == null || this.hNa.login_user_info == null || this.bnF || this.hNa.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean ckh() {
        return (this.hNa == null || this.hNa.user_info == null || TextUtils.isEmpty(this.aDB) || !this.aDB.equals(this.hNa.user_info.user_id)) ? false : true;
    }

    private boolean cki() {
        return (this.hNa == null || this.hNa.user_info == null || this.hNa.user_info.is_live_admin != 1) ? false : true;
    }

    private void wc(int i) {
        this.hMV.setVisibility(i);
        this.hMY.setVisibility(i);
    }

    private void wd(int i) {
        this.hMW.setVisibility(i);
        this.hMZ.setVisibility(i);
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
