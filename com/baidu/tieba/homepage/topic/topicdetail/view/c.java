package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends m {
    private EditText fpZ;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fok = false;
        this.foj = 3;
        this.fnp = new TopicDetaiInputContainer(context);
        this.fpZ = ((TopicDetaiInputContainer) this.fnp).getInputView();
        ((TopicDetaiInputContainer) this.fnp).setHint(context.getString(R.string.say_your_point));
        this.fol = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fpZ;
    }
}
