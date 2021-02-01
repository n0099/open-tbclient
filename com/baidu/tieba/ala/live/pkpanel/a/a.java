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
/* loaded from: classes11.dex */
public class a {
    private TextView hmm;
    private RecyclerView hmn;
    private JSONObject hmo;
    private com.baidu.tieba.ala.live.pkpanel.b.a hmp;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.hmo = jSONObject;
        this.mOrientation = i;
        parseData(this.hmo);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.hmm = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.hmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.hmn = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.hmn.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.hmp != null) {
            this.title.setText(this.hmp.mTitle);
            bVar.setData(this.hmp.gQb);
        }
        this.hmn.setAdapter(bVar);
    }

    public void QE() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        uU(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.hmp == null) {
            this.hmp = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.hmp.parseData(jSONObject);
    }

    private void uU(int i) {
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

    public void uV(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            QE();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gQb;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gQb = list;
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
            if (this.gQb != null) {
                if ((viewHolder instanceof c) && this.gQb.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gQb.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0652a) {
                    ((C0652a) viewHolder).a(a.this.hmp);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.hmp == null || a.this.hmp.gQb == null) {
                return 0;
            }
            return a.this.hmp.gQb.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return uW(i) ? 2 : 1;
        }

        private boolean uW(int i) {
            return (a.this.hmp == null || a.this.hmp.gQb == null || a.this.hmp.gQb.size() != i) ? false : true;
        }
    }

    /* loaded from: classes11.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView enq;
        private TextView hmr;
        private HeadImageView hms;
        private TextView hmt;
        private com.baidu.tieba.ala.live.pkpanel.b.b hmu;

        public c(@NonNull View view) {
            super(view);
            this.hms = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.enq = (TextView) view.findViewById(a.f.gift_name);
            this.hmt = (TextView) view.findViewById(a.f.gift_type);
            this.hmr = (TextView) view.findViewById(a.f.gift_describe);
            if (this.hms != null) {
                this.hms.setIsRound(true);
                this.hms.setAutoChangeStyle(false);
                this.hms.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.hmu = bVar;
            if (this.hmu != null && i < a.this.hmp.gQb.size()) {
                if (TextUtils.isEmpty(this.hmu.icon)) {
                    this.hms.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.hms.setUrl(this.hmu.icon);
                    m.a(this.hms, this.hmu.icon, false, false);
                }
                this.enq.setText(this.hmu.name);
                this.hmt.setText(this.hmu.type);
                this.hmt.setTextColor(Color.parseColor(this.hmu.hmw));
                this.hmr.setText(this.hmu.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0652a extends RecyclerView.ViewHolder {
        TextView hmr;
        TextView title;

        public C0652a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.hmr = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.hmr.setText(aVar.hmv);
            }
        }
    }
}
