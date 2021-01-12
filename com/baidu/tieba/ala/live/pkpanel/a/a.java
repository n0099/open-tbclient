package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private TextView hhY;
    private RecyclerView hhZ;
    private JSONObject hia;
    private com.baidu.tieba.ala.live.pkpanel.b.a hib;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.hia = jSONObject;
        this.mOrientation = i;
        parseData(this.hia);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.hhY = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.hhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.hhZ = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.hhZ.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.hib != null) {
            this.title.setText(this.hib.mTitle);
            bVar.setData(this.hib.gNv);
        }
        this.hhZ.setAdapter(bVar);
    }

    public void Pd() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        uK(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.hib == null) {
            this.hib = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.hib.parseData(jSONObject);
    }

    private void uK(int i) {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (i == 1) {
                attributes.height = -2;
                attributes.width = -2;
            } else {
                attributes.width = -2;
                attributes.height = d(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int d(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public boolean isShowing() {
        return this.mDialog != null && this.mDialog.isShowing();
    }

    public void hide() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public void uL(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            Pd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gNv;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gNv = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0652a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gNv != null) {
                if ((viewHolder instanceof c) && this.gNv.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gNv.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0652a) {
                    ((C0652a) viewHolder).a(a.this.hib);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.hib == null || a.this.hib.gNv == null) {
                return 0;
            }
            return a.this.hib.gNv.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return uM(i) ? 2 : 1;
        }

        private boolean uM(int i) {
            return (a.this.hib == null || a.this.hib.gNv == null || a.this.hib.gNv.size() != i) ? false : true;
        }
    }

    /* loaded from: classes10.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView eli;
        private TextView hie;
        private HeadImageView hif;
        private TextView hig;
        private com.baidu.tieba.ala.live.pkpanel.b.b hih;

        public c(@NonNull View view) {
            super(view);
            this.hif = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.eli = (TextView) view.findViewById(a.f.gift_name);
            this.hig = (TextView) view.findViewById(a.f.gift_type);
            this.hie = (TextView) view.findViewById(a.f.gift_describe);
            if (this.hif != null) {
                this.hif.setIsRound(true);
                this.hif.setAutoChangeStyle(false);
                this.hif.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.hih = bVar;
            if (this.hih != null && i < a.this.hib.gNv.size()) {
                if (TextUtils.isEmpty(this.hih.icon)) {
                    this.hif.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.hif.setUrl(this.hih.icon);
                    m.a(this.hif, this.hih.icon, false, false);
                }
                this.eli.setText(this.hih.name);
                this.hig.setText(this.hih.type);
                this.hig.setTextColor(Color.parseColor(this.hih.hij));
                this.hie.setText(this.hih.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0652a extends RecyclerView.ViewHolder {
        TextView hie;
        TextView title;

        public C0652a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.hie = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.hie.setText(aVar.hii);
            }
        }
    }
}
