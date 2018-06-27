package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i implements o {
    private int LV;
    HeadImageView ekP;
    ImageView ekQ;
    TextView ekR;
    private com.baidu.adp.widget.ImageView.a ekS = null;
    private a ekT = null;
    CreateGroupStepActivity ekp;
    private int ekt;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ekp = null;
        this.mView = null;
        this.ekP = null;
        this.ekQ = null;
        this.ekR = null;
        this.ekp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step3_view, (ViewGroup) null);
        this.ekQ = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.ekP = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.ekR = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.LV = i2;
        this.ekt = i3;
    }

    public void aHt() {
        if (this.ekT != null) {
            this.ekT.cancel();
        }
        this.ekS = null;
        this.ekT = new a();
        this.ekT.execute(new Object[0]);
    }

    public ImageView aHu() {
        return this.ekQ;
    }

    public TextView aHv() {
        return this.ekR;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHe() {
        this.ekQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHf() {
        this.ekp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ekp.getLayoutMode().onModeChanged(this.mView);
        this.ekP.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.ab(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.ekP.setVisibility(0);
                i.this.ekS = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ekS.a(i.this.ekP);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ekp.getPageContext().getString(d.k.group_create_step_photo), Integer.valueOf(this.LV));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aHh() {
        if (this.mIndex != this.ekt) {
            return this.ekp.getPageContext().getString(d.k.next_step);
        }
        return this.ekp.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHi() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHj() {
        return true;
    }
}
